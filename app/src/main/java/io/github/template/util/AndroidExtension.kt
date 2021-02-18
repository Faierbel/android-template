package io.github.template.util

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService

fun Activity.hideSoftInput() {
    getSystemService<InputMethodManager>()?.hideSoftInputFromWindow(
        window.decorView.applicationWindowToken,
        0
    )
}

fun View.showSoftInput() {
    context.getSystemService<InputMethodManager>()?.showSoftInput(this, 0)
}

fun Context.dpToPx(dp: Float) =
    (dp * resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
