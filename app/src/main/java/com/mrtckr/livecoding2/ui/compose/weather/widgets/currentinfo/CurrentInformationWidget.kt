package com.mrtckr.livecoding2.ui.compose.weather.widgets.currentinfo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding.domain.entity.FeltTemperature
import com.mrtckr.livecoding.domain.entity.OverlapCurrentInformationWidget
import com.mrtckr.livecoding.domain.entity.RainfallForecast
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding.domain.entity.ViewingDistance
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants.CURRENT_INFORMATION_WIDGET_TRANSLATION_Y
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants.INVISIBLE_ALPHA
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants.VISIBLE_ALPHA
import com.mrtckr.livecoding2.ui.compose.weather.util.MyAppTheme

@Composable
fun CurrentInformationWidget(
    weatherData: WeatherData, overlapCurrentInformationWidget: OverlapCurrentInformationWidget
) {

    val temperatureDescriptionAlphaAnimation by animateFloatAsState(
        targetValue = if (overlapCurrentInformationWidget.overlapTemperature) VISIBLE_ALPHA else INVISIBLE_ALPHA,
        animationSpec = tween(durationMillis = CURRENT_INFORMATION_WIDGET_TRANSLATION_Y),
        label = ""
    )

    val descriptionAlphaAnimation by animateFloatAsState(
        targetValue = if (overlapCurrentInformationWidget.overlapDescription) VISIBLE_ALPHA else INVISIBLE_ALPHA,
        animationSpec = tween(durationMillis = CURRENT_INFORMATION_WIDGET_TRANSLATION_Y),
        label = ""
    )

    val temperatureMin = weatherData.temperatureMin
    val temperatureMax = weatherData.temperatureMax
    val temperature = weatherData.temperature
    val description = weatherData.description

    Column {
        Text(
            text = weatherData.cityName,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            fontSize = dimensionResource(id = R.dimen.xxlarge_text).value.sp
        )
        AnimatedVisibility(visible = overlapCurrentInformationWidget.overlapCityName) {
            Text(
                text = stringResource(R.string.temperature, weatherData.temperature),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center,
                fontSize = dimensionResource(id = R.dimen.current_information_animated_title_text_size).value.sp
            )
        }
        AnimatedVisibility(visible = !overlapCurrentInformationWidget.overlapCityName) {
            Text(
                text = stringResource(
                    id = R.string.collapsed_current_information, temperature, description
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = dimensionResource(id = R.dimen.current_information_animated_description_bottom_padding)),
                textAlign = TextAlign.Center,
                fontSize = dimensionResource(id = R.dimen.current_information_animated_description_text_size).value.sp
            )
        }

        Text(
            text = weatherData.description,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .alpha(descriptionAlphaAnimation)
                .testTag("ExpandedDescriptionText"),
            textAlign = TextAlign.Center,
            fontSize = dimensionResource(id = R.dimen.large_text).value.sp
        )

        Text(
            text = stringResource(
                id = R.string.temperature_range, temperatureMin, temperatureMax
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .alpha(temperatureDescriptionAlphaAnimation)
                .testTag("CollapsedDescriptionText"),
            textAlign = TextAlign.Center,
            fontSize = dimensionResource(id = R.dimen.large_text).value.sp
        )
    }

}

@Preview
@Composable
fun CurrentInformationWidgetCollapsedLongTextPreview() {
    MyAppTheme {
        Surface {
            CurrentInformationWidget(
                weatherData = WeatherData(
                    cityName = "Loooong Istanbul Istanbul Istanbul Istanbul",
                    description = "Looooong Cloudy",
                    forecast = arrayListOf(),
                    forecastHours = arrayListOf(),
                    temperature = 123123,
                    temperatureMax = 12,
                    temperatureMin = 0,
                    uvIndex = UVIndex(
                        indexPoint = 0, status = ""
                    ),
                    rainfallForecast = RainfallForecast(
                        index = "", description = ""
                    ),
                    feltTemperature = FeltTemperature(
                        degree = 0, description = ""
                    ),
                    viewingDistance = ViewingDistance(
                        visibleDistance = "", description = ""
                    )
                ), overlapCurrentInformationWidget = OverlapCurrentInformationWidget(
                    overlapTemperature = false, overlapDescription = false, overlapCityName = false
                )
            )
        }
    }
}

@Preview
@Composable
fun CurrentInformationWidgetExpandedPreview() {
    MyAppTheme {
        Surface {
            CurrentInformationWidget(
                weatherData = WeatherData(
                    cityName = "Istanbul",
                    description = "Cloudy",
                    forecast = arrayListOf(),
                    forecastHours = arrayListOf(),
                    temperature = 3,
                    temperatureMax = 0,
                    temperatureMin = 0,
                    uvIndex = UVIndex(
                        indexPoint = 0, status = ""
                    ),
                    rainfallForecast = RainfallForecast(
                        index = "", description = ""
                    ),
                    feltTemperature = FeltTemperature(
                        degree = 0, description = ""
                    ),
                    viewingDistance = ViewingDistance(
                        visibleDistance = "", description = ""
                    )
                ), overlapCurrentInformationWidget = OverlapCurrentInformationWidget(
                    overlapTemperature = true, overlapDescription = true, overlapCityName = true
                )
            )
        }
    }
}

@Preview(device = "id:Nexus 10")
@Composable
fun CurrentInformationWidgetPartlyExpandedLongTextTabletPreview() {
    MyAppTheme {
        Surface {
            CurrentInformationWidget(
                weatherData = WeatherData(
                    cityName = "Looooooooooong Istanbul Istanbul Istanbul Istanbul Istanbul Istanbul",
                    description = "Cloudy",
                    forecast = arrayListOf(),
                    forecastHours = arrayListOf(),
                    temperature = 34250928,
                    temperatureMax = 0,
                    temperatureMin = 0,
                    uvIndex = UVIndex(
                        indexPoint = 0, status = ""
                    ),
                    rainfallForecast = RainfallForecast(
                        index = "", description = ""
                    ),
                    feltTemperature = FeltTemperature(
                        degree = 0, description = ""
                    ),
                    viewingDistance = ViewingDistance(
                        visibleDistance = "", description = ""
                    )
                ), overlapCurrentInformationWidget = OverlapCurrentInformationWidget(
                    overlapTemperature = false, overlapDescription = false, overlapCityName = true
                )
            )
        }
    }
}
