package com.mrtckr.livecoding2.ui.compose.weather.extensions

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding2.R

@Preview
@Composable
fun WeatherDataPrivacyInformation() {
    val fullText = stringResource(R.string.privacy_information)
    val weatherText = stringResource(R.string.first_underlined_text)
    val mapText = stringResource(R.string.second_underlined_part)

    val weatherStartIndex = fullText.indexOf(weatherText)
    val weatherEndIndex = weatherStartIndex + weatherText.length
    val mapStartIndex = fullText.indexOf(mapText)
    val mapEndIndex = mapStartIndex + mapText.length

    val annotatedString = AnnotatedString.Builder().apply {
        append(fullText)

        if (weatherStartIndex >= Constants.DEFAULT_VALUE) {
            addStyle(
                style = SpanStyle(textDecoration = TextDecoration.Underline),
                start = weatherStartIndex,
                end = weatherEndIndex
            )
        }

        if (mapStartIndex >= Constants.DEFAULT_VALUE) {
            addStyle(
                style = SpanStyle(textDecoration = TextDecoration.Underline),
                start = mapStartIndex,
                end = mapEndIndex
            )
        }
    }.toAnnotatedString()

    Text(
        text = annotatedString,
        color = Color.Black,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.normal_padding)),
        fontSize = dimensionResource(id = R.dimen.small_normal_text).value.sp
    )
}
