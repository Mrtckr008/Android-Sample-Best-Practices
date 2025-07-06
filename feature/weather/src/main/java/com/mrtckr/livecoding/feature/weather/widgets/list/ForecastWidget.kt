package com.mrtckr.livecoding.feature.weather.widgets.list

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.feature.weather.R
import com.mrtckr.common.ui.Constants
import com.mrtckr.common.ui.pxToDp
import com.mrtckr.common.ui.theme.MyAppTheme

@Composable
fun ForecastWidget(
    weatherData: WeatherData, forecastWidgetLowerPartBounds: MutableState<Float?>, context: Context
) {
    Box(modifier = Modifier
        .padding(dimensionResource(id = R.dimen.normal_padding))
        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.widgets_corner_shape_value)))
        .background(MaterialTheme.colorScheme.onSurface)
        .fillMaxWidth()
        .wrapContentHeight()
        .defaultMinSize(minHeight = dimensionResource(id = R.dimen.forecast_widget_min_height))
        .onGloballyPositioned { coordinates ->
            val toDp = pxToDp(context, coordinates.boundsInRoot().top)
            forecastWidgetLowerPartBounds.value = toDp
        }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(Modifier.alpha(Constants.FORECAST_TITLE_ALPHA)) {
                Icon(
                    imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = stringResource(id = R.string.content_description),
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = dimensionResource(id = R.dimen.normal_padding))
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = stringResource(R.string.weekly_forecast_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(dimensionResource(id = R.dimen.normal_padding))
                )
            }

            HorizontalDivider(
                thickness = dimensionResource(id = R.dimen.divider_height), color = Color.Gray
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.normal_spacer_size)))
            ForecastDailyList(weatherData = weatherData)
        }
    }
}

@Preview
@Composable
fun PreviewForecastWidget() {
    MyAppTheme {
        Surface {
            val scrollableWidgetBounds = remember { mutableStateOf<Float?>(null) }
            ForecastWidget(mockWeatherData, scrollableWidgetBounds, LocalContext.current)
        }
    }
}
