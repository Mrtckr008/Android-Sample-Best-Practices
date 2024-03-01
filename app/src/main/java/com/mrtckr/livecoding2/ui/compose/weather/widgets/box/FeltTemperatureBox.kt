package com.mrtckr.livecoding2.ui.compose.weather.widgets.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeviceThermostat
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.mrtckr.livecoding.domain.entity.weather.FeltTemperature
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.util.Constants
import com.mrtckr.livecoding2.ui.compose.util.MyAppTheme

@Composable
fun FeltTemperature(feltTemperature: FeltTemperature?, modifier: Modifier = Modifier) {
    Column(modifier) {
        Row {
            Icon(
                imageVector = Icons.Filled.DeviceThermostat,
                contentDescription = stringResource(id = R.string.content_description),
                tint = Color.White,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.weather_information_box_icon_size))
                    .align(Alignment.CenterVertically)
                    .alpha(Constants.INFORMATION_BOX_ALPHA)
            )
            Text(
                text = stringResource(R.string.felt_tempareture),
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
            text = feltTemperature?.degree.toString(),
            color = Color.White,
            fontSize = dimensionResource(
                id = R.dimen.xxlarge_text
            ).value.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(text = feltTemperature?.description ?: "", color = Color.White)
        Spacer(
            modifier = Modifier.height(
                dimensionResource(
                    id = R.dimen.xlarge_spacer_size
                )
            )
        )
    }
}

@Preview(device = "id:pixel_5")
@Composable
fun FeltTemperaturePreview() {
    MyAppTheme {
        Surface {
            FeltTemperature(
                feltTemperature = FeltTemperature(
                    32, "Hot day"
                ),
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.normal_padding))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_information_box_corner_shape)))
                    .background(MaterialTheme.colorScheme.onSurface)
                    .height(dimensionResource(id = R.dimen.weather_information_box_height))
                    .padding(dimensionResource(id = R.dimen.normal_padding))
            )
        }
    }
}
