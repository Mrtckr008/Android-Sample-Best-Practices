package com.mrtckr.livecoding2.ui.compose.extensions

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.mrtckr.livecoding2.R

@Composable
fun TemperatureBarChart(
    filledFraction: Pair<Float, Float> = 0.3f to 0.6f,
    fillColor: Color = Color.Cyan,
    emptyColor: Color = Color.DarkGray,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.weather_bar_chart_height))
            .width(dimensionResource(id = R.dimen.weather_bar_chart_width))
            .then(modifier)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val barWidth = size.width
            val barHeight = size.height
            val filledWidthStart = barWidth * filledFraction.first
            val filledWidthEnd = barWidth * filledFraction.second

            drawRect(
                color = emptyColor,
                size = Size(barWidth, barHeight)
            )

            drawRect(
                color = fillColor,
                topLeft = Offset(filledWidthStart, Constants.DEFAULT_VALUE),
                size = Size(filledWidthEnd - filledWidthStart, barHeight)
            )
        }
    }
}
