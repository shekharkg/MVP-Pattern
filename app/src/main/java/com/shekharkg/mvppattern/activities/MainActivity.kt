package com.shekharkg.mvppattern.activities

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.shekharkg.mvppattern.R
import com.shekharkg.mvppattern.presenters.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

  private var mainActivityPresenter: MainActivityPresenter? = null

  private var progressBar: ProgressBar? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mainActivityPresenter = MainActivityPresenter(this)

    initProgressbar()

    addTextWatchers()
  }

  private fun addTextWatchers() {
    usernameET.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        mainActivityPresenter?.updateUsername(s.toString())
      }

      override fun afterTextChanged(s: Editable?) {
        hideProgress()
      }

    })


    emailET.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        mainActivityPresenter?.updateEmail(s.toString())
      }

      override fun afterTextChanged(s: Editable?) {
        hideProgress()
      }
    })
  }

  private fun initProgressbar() {
    progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleSmall)
    progressBar?.isIndeterminate = true

    val params = RelativeLayout.LayoutParams(Resources.getSystem().displayMetrics.widthPixels, 250)
    params.addRule(RelativeLayout.CENTER_IN_PARENT)
    this.addContentView(progressBar, params)
    showProgress()
  }

  override fun updateTextView(info: String) {
    textView.text = info
  }

  override fun showProgress() {
    progressBar?.visibility = View.VISIBLE
  }

  override fun hideProgress() {
    progressBar?.visibility = View.INVISIBLE
  }
}
