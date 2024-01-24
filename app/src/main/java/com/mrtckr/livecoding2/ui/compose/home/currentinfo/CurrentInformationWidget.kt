package com.mrtckr.livecoding2.ui.compose.home.currentinfo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding.domain.entity.OverlapCurrentInformationWidget
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.extensions.Constants.CURRENT_INFORMATION_WIDGET_TRANSLATION_Y
import com.mrtckr.livecoding2.ui.compose.extensions.Constants.INVISIBLE_ALPHA
import com.mrtckr.livecoding2.ui.compose.extensions.Constants.VISIBLE_ALPHA

@Composable
fun CurrentInformationWidget(
    weatherData: ResultData<WeatherData>,
    overlapCurrentInformationWidget: OverlapCurrentInformationWidget
) {

    val alphaAnimation by animateFloatAsState(
        targetValue = if (overlapCurrentInformationWidget.overlapTemperature) VISIBLE_ALPHA else INVISIBLE_ALPHA,
        animationSpec = tween(durationMillis = CURRENT_INFORMATION_WIDGET_TRANSLATION_Y),
        label = ""
    )

    val alphaAnimation2 by animateFloatAsState(
        targetValue = if (overlapCurrentInformationWidget.overlapDescription) VISIBLE_ALPHA else INVISIBLE_ALPHA,
        animationSpec = tween(durationMillis = CURRENT_INFORMATION_WIDGET_TRANSLATION_Y),
        label = ""
    )

    when (weatherData) {
        is ResultData.Success -> {
            val temperatureMin = weatherData.data.temperatureMin
            val temperatureMax = weatherData.data.temperatureMax
            val temperature = weatherData.data.temperature
            val description = weatherData.data.description

            Column {
                Text(
                    text = weatherData.data.cityName,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    fontSize = dimensionResource(id = R.dimen.xxlarge_text).value.sp
                )
                AnimatedVisibility(visible = overlapCurrentInformationWidget.overlapCityName) {
                    Text(
                        text = stringResource(R.string.temperature, weatherData.data.temperature),
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
                    text = weatherData.data.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .alpha(alphaAnimation2),
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
                        .alpha(alphaAnimation),
                    textAlign = TextAlign.Center,
                    fontSize = dimensionResource(id = R.dimen.large_text).value.sp
                )
            }
        }

        else -> {}
    }
}
