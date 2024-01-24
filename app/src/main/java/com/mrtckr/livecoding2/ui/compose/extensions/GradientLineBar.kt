package com.mrtckr.livecoding2.ui.compose.extensions

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrtckr.livecoding2.R

@Preview
@Composable
fun GradientLineBar() {
    val brush = Brush.horizontalGradient(
        colors = listOf(
            Color.Green, Color.Yellow, Color(0xFFFFA500), Color.Red, Color.Magenta
        )
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.uv_chart_height))
    ) {
        drawLine(
            brush = brush,
            start = Offset.Zero,
            end = Offset(size.width, Constants.DEFAULT_VALUE),
            strokeWidth = size.height
        )
    }
}
