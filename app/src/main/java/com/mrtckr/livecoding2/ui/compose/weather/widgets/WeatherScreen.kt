package com.mrtckr.livecoding2.ui.compose.weather.widgets

import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mrtckr.livecoding.domain.entity.FeltTemperature
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.ForecastHours
import com.mrtckr.livecoding.domain.entity.OverlapCurrentInformationWidget
import com.mrtckr.livecoding.domain.entity.RainfallForecast
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding.domain.entity.ViewingDistance
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants.SCROLLABLE_WIDGET_TOP_POINT
import com.mrtckr.livecoding2.ui.compose.weather.extensions.VideoPlayerBackground
import com.mrtckr.livecoding2.ui.compose.weather.extensions.WeatherMapBox
import com.mrtckr.livecoding2.ui.compose.weather.util.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.weather.widgets.bottominfo.BottomToolbar
import com.mrtckr.livecoding2.ui.compose.weather.widgets.box.WeatherInformationBox
import com.mrtckr.livecoding2.ui.compose.weather.widgets.currentinfo.CurrentInformationWidget
import com.mrtckr.livecoding2.ui.compose.weather.widgets.list.ForecastHourlyWidget
import com.mrtckr.livecoding2.ui.compose.weather.widgets.list.ForecastWidget

private const val sampleCityName = "Istanbul"

@Preview
@Composable
fun WeatherScreen(viewModel: WeatherComposeViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {
        VideoPlayerBackground(videoResId = R.raw.sunny_background)

        val weatherUIState by viewModel.getWeatherState("Istanbul").collectAsStateWithLifecycle()

        val context = LocalContext.current

        when (val weatherData = weatherUIState) {
            is WeatherDataUiState.Success -> WeatherScreenBox(
                weatherData = weatherData.weatherData, context = context
            )

            is WeatherDataUiState.Loading -> {

            }
        }
    }
}

@Composable
fun WeatherScreenBox(
    weatherData: WeatherData, context: Context, scrollState: ScrollState = rememberScrollState()
) {
    val scrollableWidgetBounds = remember { mutableStateOf<Float?>(null) }
    val forecastWidgetLowerPartBounds = remember { mutableStateOf<Float?>(null) }
    val weatherMapLowerPartBounds = remember { mutableStateOf<Float?>(null) }

    val forecastTop = forecastWidgetLowerPartBounds.value ?: Constants.DEFAULT_VALUE
    val weatherMapTop = weatherMapLowerPartBounds.value ?: Constants.DEFAULT_VALUE
    val scrollableWidgetTopPoint = scrollableWidgetBounds.value ?: Constants.DEFAULT_VALUE

    val overlapCurrentInformationWidget = calculateOverlap(scrollableWidgetTopPoint)

    val shouldMoveUp = remember { mutableStateOf(false) }
    val currentInformationWidgetTranslationY =
        calculateCurrentInformationWidgetTranslationY(shouldMoveUp)
    val currentInformationWidgetAlphaAnimation =
        calculateCurrentInformationWidgetAlphaAnimation(scrollableWidgetTopPoint)
    Box(
        Modifier
            .padding(top = dimensionResource(id = R.dimen.parent_screen_top_padding))
            .fillMaxWidth()
            .wrapContentHeight()
            .graphicsLayer {
                translationY = currentInformationWidgetTranslationY
            }) {
        shouldMoveUp.value = scrollableWidgetTopPoint < SCROLLABLE_WIDGET_TOP_POINT
        CurrentInformationWidget(weatherData, overlapCurrentInformationWidget)
        SectionTabBarTitle(
            currentInformationWidgetAlphaAnimation,
            weatherMapTop,
            forecastTop,
            scrollableWidgetTopPoint
        )
    }

    Box(
        Modifier
            .padding(top = dimensionResource(id = R.dimen.scrollable_bar_top_padding))
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(scrollState)
            .testTag("ScrollableWidgetsBox")
    ) {
        Column {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.scrollable_bar_top_space)))
            ForecastHourlyWidget(weatherData, scrollableWidgetBounds, context)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.forecast_widgets_between_space)))
            ForecastWidget(weatherData, forecastWidgetLowerPartBounds, context)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.weekly_forecast_and_map_between_space)))
            WeatherMapBox(weatherMapLowerPartBounds)
            WeatherInformationBox(weatherData)
            BottomToolbar(cityName = sampleCityName)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.parent_widget_bottom_space)))
        }
    }

}

@Composable
fun calculateCurrentInformationWidgetTranslationY(shouldMoveUp: MutableState<Boolean>): Float {
    val currentInformationWidgetDistanceY = with(LocalDensity.current) {
        dimensionResource(id = R.dimen.current_information_widget_distance_y).toPx()
    }
    return animateFloatAsState(
        targetValue = if (shouldMoveUp.value) -currentInformationWidgetDistanceY else Constants.DEFAULT_VALUE,
        animationSpec = tween(durationMillis = Constants.CURRENT_INFORMATION_WIDGET_TRANSLATION_Y),
        label = "CurrentInformationWidgetTranslationY"
    ).value
}

@Composable
fun calculateCurrentInformationWidgetAlphaAnimation(scrollableWidgetTopPoint: Float): Float {
    return animateFloatAsState(
        targetValue = if (scrollableWidgetTopPoint < Constants.CURRENT_INFORMATION_WIDGET_ALPHA_ANIMATION_TOP_THRESHOLD) 1f else Constants.DEFAULT_VALUE,
        animationSpec = tween(durationMillis = Constants.CURRENT_INFORMATION_WIDGET_ALPHA_ANIMATION_DURATION),
        label = "CurrentInformationWidgetAlphaAnimation"
    ).value
}

fun calculateOverlap(scrollableWidgetTopPoint: Float): OverlapCurrentInformationWidget {
    return OverlapCurrentInformationWidget(
        overlapTemperature = Constants.OVERLAP_CURRENT_INFORMATION_WIDGET_TEMPERATURE_THRESHOLD <= scrollableWidgetTopPoint,
        overlapDescription = Constants.OVERLAP_CURRENT_INFORMATION_WIDGET_DESCRIPTION_THRESHOLD <= scrollableWidgetTopPoint,
        overlapCityName = Constants.OVERLAP_CURRENT_INFORMATION_WIDGET_CITY_NAME_THRESHOLD <= scrollableWidgetTopPoint
    )
}

@Preview(device = "spec:parent=Nexus 10,orientation=portrait", fontScale = 1.3f)
@Composable
fun WeatherTabletPreviewLargestSystemFontScreen() {
    MyAppTheme {
        Surface {
            WeatherScreenBox(
                weatherData = WeatherData(
                    cityName = "Istanbul", "Cloudy", forecast = arrayListOf(
                        Forecast(
                            day = "Today",
                            temperatureMax = 12,
                            temperatureMin = 0,
                            weatherStatus = WeatherStatus.CLOUDY
                        ), Forecast(
                            day = "Friday",
                            temperatureMax = 5,
                            temperatureMin = -1,
                            weatherStatus = WeatherStatus.SNOWY
                        ), Forecast(
                            day = "Saturday",
                            temperatureMax = 5,
                            temperatureMin = 0,
                            weatherStatus = WeatherStatus.RAINY
                        ), Forecast(
                            day = "Sunday",
                            temperatureMax = 6,
                            temperatureMin = 1,
                            weatherStatus = WeatherStatus.CLOUDY
                        ), Forecast(
                            day = "Monday",
                            temperatureMax = 6,
                            temperatureMin = 0,
                            weatherStatus = WeatherStatus.CLOUDY
                        ), Forecast(
                            day = "Tuesday",
                            temperatureMax = 4,
                            temperatureMin = -1,
                            weatherStatus = WeatherStatus.SNOWY
                        ), Forecast(
                            day = "Wednesday",
                            temperatureMax = 7,
                            temperatureMin = 1,
                            weatherStatus = WeatherStatus.RAINY
                        ), Forecast(
                            day = "Thursday",
                            temperatureMax = 10,
                            temperatureMin = 3,
                            weatherStatus = WeatherStatus.CLOUDY
                        ), Forecast(
                            day = "Friday",
                            temperatureMax = 14,
                            temperatureMin = 7,
                            weatherStatus = WeatherStatus.SUNNY
                        ), Forecast(
                            day = "Saturday",
                            temperatureMax = 15,
                            temperatureMin = 8,
                            weatherStatus = WeatherStatus.SUNNY
                        ), Forecast(
                            day = "Sunday",
                            temperatureMax = 10,
                            temperatureMin = 1,
                            weatherStatus = WeatherStatus.CLOUDY
                        ), Forecast(
                            day = "Monday",
                            temperatureMax = 6,
                            temperatureMin = -1,
                            weatherStatus = WeatherStatus.RAINY
                        ), Forecast(
                            day = "Tuesday",
                            temperatureMax = 3,
                            temperatureMin = -4,
                            weatherStatus = WeatherStatus.SNOWY
                        ), Forecast(
                            day = "Wednesday",
                            temperatureMax = -3,
                            temperatureMin = -10,
                            weatherStatus = WeatherStatus.SNOWY
                        ), Forecast(
                            day = "Thursday",
                            temperatureMax = -2,
                            temperatureMin = -9,
                            weatherStatus = WeatherStatus.SNOWY
                        )
                    ), temperature = 8, temperatureMax = 12, temperatureMin = 0, uvIndex = UVIndex(
                        indexPoint = 0, status = "Low\nFor rest of the day"
                    ), rainfallForecast = RainfallForecast(
                        index = "0 mm",
                        description = "In the last 24 hours\nNo rain is expected in the next 10 days."
                    ), feltTemperature = FeltTemperature(
                        degree = 2, description = "The wind feels colder"
                    ), forecastHours = arrayListOf(
                        ForecastHours(
                            hour = "14", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "15", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "16", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "17", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "18", temperature = 6, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "19", temperature = 5, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "20", temperature = 4, weatherStatus = WeatherStatus.RAINY,
                        ), ForecastHours(
                            hour = "21", temperature = 4, weatherStatus = WeatherStatus.RAINY,
                        ), ForecastHours(
                            hour = "22", temperature = 3, weatherStatus = WeatherStatus.RAINY,
                        ), ForecastHours(
                            hour = "23", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "00", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
                        ), ForecastHours(
                            hour = "01", temperature = 0, weatherStatus = WeatherStatus.SNOWY,
                        ), ForecastHours(
                            hour = "02", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
                        ), ForecastHours(
                            hour = "03", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
                        ), ForecastHours(
                            hour = "04", temperature = -2, weatherStatus = WeatherStatus.SNOWY,
                        ), ForecastHours(
                            hour = "05", temperature = -3, weatherStatus = WeatherStatus.SNOWY,
                        )
                    ), viewingDistance = ViewingDistance(
                        visibleDistance = "25 km", description = "It's clear now"
                    )
                ), LocalContext.current, rememberScrollState()
            )
        }
    }
}
