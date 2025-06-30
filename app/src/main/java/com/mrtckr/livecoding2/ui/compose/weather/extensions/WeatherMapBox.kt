package com.mrtckr.livecoding2.ui.compose.weather.extensions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Umbrella
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.common.pxToDp
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme

@Composable
fun WeatherMapBox(weatherMapLowerPartBounds: MutableState<Float?>) {
    val context = LocalContext.current
    Box(modifier = Modifier
        .padding(dimensionResource(id = R.dimen.normal_padding))
        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.widgets_corner_shape_value)))
        .fillMaxWidth()
        .height(dimensionResource(id = R.dimen.weather_map_box_map_size))
        .background(MaterialTheme.colorScheme.onSurface)
        .onGloballyPositioned { coordinates ->
            val toDp = pxToDp(context, coordinates.boundsInRoot().top)
            weatherMapLowerPartBounds.value = toDp
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.normal_padding))
                .align(Alignment.Center)

        ) {
            Row {
                Icon(
                    imageVector = Icons.Filled.Umbrella,
                    contentDescription = stringResource(id = R.string.content_description),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.weather_map_box_icon_size))
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.normal_spacer_size)))
                Text(stringResource(id = R.string.rain), modifier = Modifier)
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.normal_spacer_size)))
            Image(
                painter = painterResource(id = R.drawable.forecast_map),
                contentDescription = stringResource(id = R.string.content_description),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_map_box_image_corner_shape)))
            )
        }
    }
}

@Preview
@Composable
fun PreviewWeatherMapBox() {
    MyAppTheme {
        Surface {
            WeatherMapBox(remember { mutableStateOf(2f) })
        }
    }
}
