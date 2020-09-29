package com.yogasolo.test.core.extensions

import android.view.View

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}