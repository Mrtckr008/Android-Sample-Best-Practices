package com.mrtckr.livecoding2.ui.compose.weather.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Umbrella
import androidx.compose.material.icons.filled.WatchLater
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.common.Constants

@Composable
fun SectionTabBarTitle(
    currentInformationWidgetAlphaAnimation: Float,
    weatherMapTop: Float,
    forecastTop: Float,
    scrollableWidgetTopPoint: Float
) {
    Box(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.information_bar_horizontal_padding),
                top = dimensionResource(id = R.dimen.information_bar_top_padding),
                end = dimensionResource(id = R.dimen.information_bar_horizontal_padding)
            )
            .alpha(currentInformationWidgetAlphaAnimation)
            .clip(
                RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen.widgets_corner_shape_value),
                    topEnd = dimensionResource(id = R.dimen.widgets_corner_shape_value)
                )
            )
            .background(MaterialTheme.colorScheme.onSurface)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.information_bar_start_padding))
        ) {
            val icon = when {
                weatherMapTop in Constants.WEATHER_MAP_TOP_THRESHOLD_RANGE.first..Constants.WEATHER_MAP_TOP_THRESHOLD_RANGE.second -> Icons.Filled.Umbrella
                forecastTop in Constants.FORECAST_TOP_THRESHOLD_RANGE.first..Constants.FORECAST_TOP_THRESHOLD_RANGE.second -> Icons.Filled.CalendarMonth
                scrollableWidgetTopPoint in Constants.SCROLLABLE_TOP_THRESHOLD_RANGE.first..Constants.SCROLLABLE_TOP_THRESHOLD_RANGE.second -> Icons.Filled.WatchLater
                else -> Icons.Filled.CalendarMonth
            }

            val description = when {
                weatherMapTop in Constants.WEATHER_MAP_TOP_THRESHOLD_RANGE.first..Constants.WEATHER_MAP_TOP_THRESHOLD_RANGE.second -> R.string.rainfall_map
                forecastTop in Constants.FORECAST_TOP_THRESHOLD_RANGE.first..Constants.FORECAST_TOP_THRESHOLD_RANGE.second -> R.string.forecast_weeks
                scrollableWidgetTopPoint in Constants.SCROLLABLE_TOP_THRESHOLD_RANGE.first..Constants.SCROLLABLE_TOP_THRESHOLD_RANGE.second -> R.string.hourly_forecast
                else -> R.string.hourly_forecast
            }

            val tint =
                if (weatherMapTop in Constants.WEATHER_MAP_TOP_THRESHOLD_RANGE.first..Constants.WEATHER_MAP_TOP_THRESHOLD_RANGE.second) Color.Black else Color.White

            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = R.string.content_description),
                tint = tint,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Text(
                text = stringResource(id = description),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.information_bar_text_padding))
            )
        }
    }
}
