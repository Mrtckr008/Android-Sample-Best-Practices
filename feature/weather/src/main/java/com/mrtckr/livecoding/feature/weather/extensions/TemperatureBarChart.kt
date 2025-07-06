package com.mrtckr.livecoding.feature.weather.extensions

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrtckr.common.ui.Constants
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.livecoding.feature.weather.R

@Composable
fun TemperatureBarChart(
    modifier: Modifier = Modifier,
    filledFraction: Pair<Float, Float> = 0.3f to 0.6f,
    fillColor: Color = Color.Cyan,
    emptyColor: Color = Color.DarkGray,
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
                color = emptyColor, size = Size(barWidth, barHeight)
            )

            drawRect(
                color = fillColor,
                topLeft = Offset(filledWidthStart, Constants.DEFAULT_VALUE),
                size = Size(filledWidthEnd - filledWidthStart, barHeight)
            )
        }
    }
}

@Preview
@Composable
fun TemperatureBarChartPreview() {
    MyAppTheme {
        Surface {
            TemperatureBarChart(
                fillColor = Color.Cyan,
                emptyColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.normal_padding))
                    .height(dimensionResource(id = R.dimen.forecast_daily_chart_height))
                    .fillMaxWidth(),
                filledFraction = Pair(0.2f, 0.7f)
            )
        }
    }
}
