package com.mrtckr.livecoding2.ui.compose.util

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class TintTheme(
    val iconTint: Color = Color.Unspecified,
)

val LocalTintTheme = staticCompositionLocalOf { TintTheme() }
