package com.mrtckr.livecoding2.ui.compose.weather.util

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = Color(127, 199, 217),
    primaryVariant = Color(54, 84, 134),
    secondary = Color(220, 242, 241),
    onSurface = Color(0x992787AF)
)

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}
