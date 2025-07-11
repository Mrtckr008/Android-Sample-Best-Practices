package com.mrtckr.livecoding.feature.weather.widgets.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.domain.entity.weather.ForecastHours
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.feature.weather.R
import com.mrtckr.common.ui.Constants
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.livecoding.feature.weather.extensions.IconByStatus

@Composable
fun ForecastHourlyItem(weatherItem: ForecastHours) {
    Column(Modifier.wrapContentSize()) {
        Text(
            text = weatherItem.hour, modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.normal_padding), top = dimensionResource(
                        id = R.dimen.big_normal_padding
                    )
                )
                .wrapContentSize()
        )

        IconByStatus(
            weatherItem.weatherStatus,
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.normal_padding))
                .weight(1f)
        )

        Text(
            text = stringResource(R.string.temperature, weatherItem.temperature),
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.normal_padding),
                    bottom = dimensionResource(id = R.dimen.big_normal_padding)
                )
                .align(Alignment.CenterHorizontally)
        )
    }

    HorizontalDivider(
        Modifier
            .alpha(Constants.FORECAST_DIVIDER_ALPHA)
            .padding(dimensionResource(id = R.dimen.big_normal_padding)),
        thickness = dimensionResource(id = R.dimen.divider_height),
        color = Color.Gray
    )
}

@Composable
fun ForecastHourlyList(weatherData: WeatherData) {
    LazyRow {
        items(weatherData.forecast.size) { index ->
            ForecastHourlyItem(weatherData.forecastHours[index])
        }
    }
}

@Preview(wallpaper = Wallpapers.NONE, device = "id:Nexus S")
@Composable
fun ForecastHourlyItemSmallDevicePreview() {
    MyAppTheme {
        Surface(modifier = Modifier.height(80.dp)) {
            ForecastHourlyItem(mockWeatherData.forecastHours[0])
        }
    }
}
