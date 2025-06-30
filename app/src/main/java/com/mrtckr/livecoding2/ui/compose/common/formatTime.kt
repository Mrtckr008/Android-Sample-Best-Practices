package com.mrtckr.livecoding2.ui.compose.common

import androidx.compose.runtime.Composable
import java.util.Locale

@Composable
fun formatTime(ms: Float): String {
    val totalSeconds = ms.toInt() / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return String.format(Locale.getDefault(), "%d:%02d", minutes, seconds)
}
