package com.mrtckr.livecoding2.ui.compose.weather.widgets.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding.domain.entity.weather.RainfallForecast
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants
import com.mrtckr.livecoding2.ui.compose.weather.util.MyAppTheme

@Composable
fun RainfallForecastBox(rainfallForecast: RainfallForecast?, modifier: Modifier = Modifier) {
    Column(modifier) {
        Row {
            Icon(
                imageVector = Icons.Filled.WaterDrop,
                contentDescription = stringResource(id = R.string.content_description),
                tint = Color.White,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.weather_information_box_icon_size))
                    .align(Alignment.CenterVertically)
                    .alpha(Constants.INFORMATION_BOX_ALPHA)
            )
            Text(
                text = stringResource(R.string.rain),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = dimensionResource(id = R.dimen.small_text).value.sp,

                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = dimensionResource(id = R.dimen.small_padding))
                    .alpha(Constants.INFORMATION_BOX_ALPHA)
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.normal_spacer_size)))
        Text(
            text = rainfallForecast?.index.toString(),
            color = Color.White,
            fontSize = dimensionResource(
                id = R.dimen.xlarge_text
            ).value.sp
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.normal_spacer_size)))
        Text(
            text = rainfallForecast?.description.toString(),
            color = Color.White,
            fontSize = dimensionResource(
                id = R.dimen.large_text
            ).value.sp
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(device = "id:Nexus 10")
@Composable
fun RainfallForecastBoxTabletPreview() {
    MyAppTheme {
        Surface {
            RainfallForecastBox(
                rainfallForecast = RainfallForecast(
                    index = "0 mm",
                    description = "In the last 24 hours\nNo rain is expected in the next 10 days."
                ),
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.normal_padding))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_information_box_corner_shape)))
                    .height(dimensionResource(id = R.dimen.weather_information_box_height))
                    .background(MaterialTheme.colors.onSurface)
                    .padding(dimensionResource(id = R.dimen.normal_padding))
            )
        }
    }
}
