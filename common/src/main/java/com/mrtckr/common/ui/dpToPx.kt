package com.mrtckr.common.ui

import android.content.Context

fun dpToPx(context: Context, dp: Float): Int {
    return (dp * context.resources.displayMetrics.density).toInt()
}

fun pxToDp(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.density
}
