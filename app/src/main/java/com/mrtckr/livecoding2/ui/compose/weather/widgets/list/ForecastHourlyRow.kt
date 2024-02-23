package com.mrtckr.livecoding2.ui.compose.weather.widgets.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import com.mrtckr.livecoding.domain.entity.ForecastHours
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants
import com.mrtckr.livecoding2.ui.compose.weather.extensions.IconByStatus
import com.mrtckr.livecoding2.ui.compose.weather.util.MyAppTheme

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

    Divider(
        Modifier
            .alpha(Constants.FORECAST_DIVIDER_ALPHA)
            .padding(dimensionResource(id = R.dimen.big_normal_padding)),
        color = Color.Gray,
        thickness = dimensionResource(id = R.dimen.divider_height),
        startIndent = dimensionResource(id = R.dimen.normal_padding)
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
        Surface {
            ForecastHourlyItem(
                ForecastHours(
                    "23", 12, WeatherStatus.SUNNY
                )
            )
        }
    }
}
