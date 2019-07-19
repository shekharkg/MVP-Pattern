package com.shekharkg.mvppattern.modal

/**
 * Created by shekhar on 2019-07-19.
 * Tricog Health Services Pvt Ltd © 2019 | All rights reserved
 */
data class User(var username: String = "", var email: String = "") {
  override fun toString(): String {
    return "Username: $username\nEmail: $email"
  }
}