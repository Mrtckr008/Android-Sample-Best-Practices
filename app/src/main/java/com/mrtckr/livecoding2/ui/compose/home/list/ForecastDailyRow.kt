package com.mrtckr.livecoding2.ui.compose.home.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.extensions.Constants
import com.mrtckr.livecoding2.ui.compose.extensions.IconByStatus
import com.mrtckr.livecoding2.ui.compose.extensions.TemperatureBarChart

@Composable
fun ForecastDailyItem(weatherItem: Forecast) {
    Row(Modifier.fillMaxWidth()) {
        Text(
            text = weatherItem.day.substring(0, 3),
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.normal_padding))
                .width(dimensionResource(id = R.dimen.forecast_daily_item_height))
        )

        IconByStatus(
            weatherItem.weatherStatus,
            Modifier.padding(start = dimensionResource(id = R.dimen.normal_padding))
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.xxlarge_spacer_size)))

        Text(
            text = stringResource(R.string.temperature, weatherItem.temperatureMin),
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.normal_padding))
                .align(Alignment.CenterVertically)
        )

        TemperatureBarChart(
            fillColor = Color.Cyan,
            emptyColor = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.normal_padding))
                .height(dimensionResource(id = R.dimen.forecast_daily_chart_height))
                .weight(1f)
                .align(Alignment.CenterVertically),
            filledFraction = calculateWeatherBarFilledFraction(weatherItem)
        )

        Text(
            text = stringResource(R.string.temperature, weatherItem.temperatureMax),
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.normal_padding))
                .align(Alignment.CenterVertically)
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
fun ForecastDailyList(weatherData: WeatherData) {
    Column {
        weatherData.forecast.forEach { forecast ->
            ForecastDailyItem(forecast)
        }
    }
}

private fun calculateWeatherBarFilledFraction(weatherItem: Forecast): Pair<Float, Float> {
    val minRangeOfTemperature = Constants.RANGE_OF_WEATHER_TEMPERATURE_BAR.first
    val maxRangeOfTemperature = Constants.RANGE_OF_WEATHER_TEMPERATURE_BAR.second
    val minTemperatureBarFilledValue =
        (weatherItem.temperatureMin.toFloat() - minRangeOfTemperature) / (maxRangeOfTemperature - minRangeOfTemperature)
    val maxTemperatureBarFilledValue =
        (weatherItem.temperatureMax.toFloat() - minRangeOfTemperature) / (maxRangeOfTemperature - minRangeOfTemperature)
    return minTemperatureBarFilledValue to maxTemperatureBarFilledValue
}
