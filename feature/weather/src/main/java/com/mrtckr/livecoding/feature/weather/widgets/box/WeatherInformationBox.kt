package com.mrtckr.livecoding.feature.weather.widgets.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.feature.weather.R
import com.mrtckr.common.ui.theme.MyAppTheme

@Composable
fun WeatherInformationBox(weatherData: WeatherData) {
    Column {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            UVIndexBox(
                weatherData.uvIndex,
                Modifier
                    .padding(dimensionResource(id = R.dimen.normal_margin))
                    .weight(1f)
                    .height(dimensionResource(id = R.dimen.weather_information_box_height))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_information_box_corner_shape)))
                    .background(MaterialTheme.colorScheme.onSurface)
                    .padding(dimensionResource(id = R.dimen.normal_padding))
            )
            RainfallForecastBox(
                weatherData.rainfallForecast,
                Modifier
                    .padding(dimensionResource(id = R.dimen.normal_padding))
                    .weight(1f)
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_information_box_corner_shape)))
                    .height(dimensionResource(id = R.dimen.weather_information_box_height))
                    .background(MaterialTheme.colorScheme.onSurface)
                    .padding(dimensionResource(id = R.dimen.normal_padding))
            )
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            FeltTemperature(
                weatherData.feltTemperature,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.normal_padding))
                    .weight(1f)
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_information_box_corner_shape)))
                    .background(MaterialTheme.colorScheme.onSurface)
                    .height(dimensionResource(id = R.dimen.weather_information_box_height))
                    .padding(dimensionResource(id = R.dimen.normal_padding))
            )

            VisibleDistanceBox(
                viewingDistance = weatherData.viewingDistance,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.normal_padding))
                    .weight(1f)
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_information_box_corner_shape)))
                    .height(dimensionResource(id = R.dimen.weather_information_box_height))
                    .background(MaterialTheme.colorScheme.onSurface)
                    .padding(dimensionResource(id = R.dimen.normal_padding))
            )
        }
    }
}

@Preview
@Composable
fun PreviewWeatherInformationBox() {
    MyAppTheme {
        Surface {
            WeatherInformationBox(mockWeatherData)
        }
    }
}