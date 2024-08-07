package com.mrtckr.livecoding2.ui.compose.weather.widgets

import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mrtckr.livecoding.domain.entity.weather.OverlapCurrentInformationWidget
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.common.Constants
import com.mrtckr.livecoding2.ui.compose.common.Constants.SCROLLABLE_WIDGET_TOP_POINT
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.LoadingScreen
import com.mrtckr.livecoding2.ui.compose.weather.WeatherComposeViewModel
import com.mrtckr.livecoding2.ui.compose.weather.extensions.VideoPlayerBackground
import com.mrtckr.livecoding2.ui.compose.weather.extensions.WeatherMapBox
import com.mrtckr.livecoding2.ui.compose.weather.widgets.bottominfo.BottomToolbar
import com.mrtckr.livecoding2.ui.compose.weather.widgets.box.WeatherInformationBox
import com.mrtckr.livecoding2.ui.compose.weather.widgets.currentinfo.CurrentInformationWidget
import com.mrtckr.livecoding2.ui.compose.weather.widgets.list.ForecastHourlyWidget
import com.mrtckr.livecoding2.ui.compose.weather.widgets.list.ForecastWidget
import com.mrtckr.scrollboxesanimation.DynamicBoxAnimator

@Composable
fun WeatherScreenRoute(viewModel: WeatherComposeViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = dimensionResource(id = R.dimen.xxlarge_spacer_size))
    ) {
        VideoPlayerBackground(videoResId = R.raw.sunny_background)

        LaunchedEffect(Unit) {
            viewModel.updateWeatherState(mockWeatherData.cityName)
        }

        val weatherUIState by viewModel.weatherState.collectAsStateWithLifecycle()

        val context = LocalContext.current

        when (val weatherData = weatherUIState) {
            is WeatherDataUiState.Success -> WeatherScreen(
                weatherData = weatherData.weatherData, context = context
            )

            is WeatherDataUiState.Loading -> {
                LoadingScreen()
            }
        }
    }
}

@Composable
fun WeatherScreen(
    weatherData: WeatherData, context: Context
) {
    val scrollableWidgetBounds = remember { mutableStateOf<Float?>(null) }
    val forecastWidgetLowerPartBounds = remember { mutableStateOf<Float?>(null) }
    val weatherMapLowerPartBounds = remember { mutableStateOf<Float?>(null) }

    val forecastTop = forecastWidgetLowerPartBounds.value ?: Constants.DEFAULT_VALUE
    val weatherMapTop = weatherMapLowerPartBounds.value ?: Constants.DEFAULT_VALUE
    val scrollableWidgetTopPoint = scrollableWidgetBounds.value ?: Constants.DEFAULT_VALUE

    val overlapCurrentInformationWidget = calculateOverlap(scrollableWidgetTopPoint)

    val currentInformationWidgetAlphaAnimation =
        calculateCurrentInformationWidgetAlphaAnimation(scrollableWidgetTopPoint)

    DynamicBoxAnimator(
        primaryBoxContent = {
            CurrentInformationWidget(weatherData, overlapCurrentInformationWidget)
            SectionTabBarTitle(
                currentInformationWidgetAlphaAnimation,
                weatherMapTop,
                forecastTop,
                scrollableWidgetTopPoint
            )
        },
        secondaryBoxContent = {
            Column {
                ForecastHourlyWidget(weatherData, scrollableWidgetBounds, context)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.forecast_widgets_between_space)))
                ForecastWidget(weatherData, forecastWidgetLowerPartBounds, context)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.weekly_forecast_and_map_between_space)))
                WeatherMapBox(weatherMapLowerPartBounds)
                WeatherInformationBox(weatherData)
                BottomToolbar(cityName = mockWeatherData.cityName)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.parent_widget_bottom_space)))
            }
        },
        secondaryBoxTopPaddingDp = dimensionResource(id = R.dimen.scrollable_bar_top_padding),
        secondaryBoxTopSpaceDp = dimensionResource(
            id = R.dimen.scrollable_bar_top_space
        ),
        scrollActivationThreshold = SCROLLABLE_WIDGET_TOP_POINT
    )
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
            WeatherScreen(mockWeatherData, LocalContext.current)
        }
    }
}
