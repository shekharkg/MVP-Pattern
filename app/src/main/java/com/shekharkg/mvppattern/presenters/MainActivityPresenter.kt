package com.shekharkg.mvppattern.presenters

import com.shekharkg.mvppattern.modal.User

/**
 * Created by shekhar on 2019-07-19.
 * Tricog Health Services Pvt Ltd © 2019 | All rights reserved
 */
class MainActivityPresenter(private var view: View) {

  private var user: User? = null

  init {
    user = User()
  }

  fun updateUsername(name: String) {
    user?.username = name
    view.updateTextView(user.toString())
  }

  fun updateEmail(email: String) {
    user?.email = email
    view.updateTextView(user.toString())
  }

  interface View {
    fun updateTextView(info: String)
    fun showProgress()
    fun hideProgress()
  }


}