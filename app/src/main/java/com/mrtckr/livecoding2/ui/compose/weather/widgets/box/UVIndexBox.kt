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
import androidx.compose.material.icons.filled.WbTwilight
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
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.weather.extensions.Constants
import com.mrtckr.livecoding2.ui.compose.weather.extensions.GradientLineBar
import com.mrtckr.livecoding2.ui.compose.weather.util.MyAppTheme

@Composable
fun UVIndexBox(uvIndex: UVIndex?, modifier: Modifier = Modifier) {
    Column(modifier) {
        Row {
            Icon(
                imageVector = Icons.Filled.WbTwilight,
                contentDescription = stringResource(id = R.string.content_description),
                tint = Color.White,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.weather_information_box_icon_size))
                    .align(Alignment.CenterVertically)
                    .alpha(Constants.INFORMATION_BOX_ALPHA)
            )
            Text(
                text = stringResource(R.string.uv_index),
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
            text = (uvIndex?.indexPoint ?: 0).toString(),
            color = Color.White,
            fontSize = dimensionResource(
                id = R.dimen.xxlarge_text
            ).value.sp
        )
        Text(
            text = uvIndex?.status ?: "",
            color = Color.White,
            fontSize = dimensionResource(id = R.dimen.large_text).value.sp
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.normal_spacer_size)))
        GradientLineBar()
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.normal_spacer_size)))
        Text(
            text = stringResource(R.string.rest_of_the_day),
            color = Color.White,
            fontSize = dimensionResource(
                id = R.dimen.normal_text
            ).value.sp
        )
    }
}

@Preview
@Composable
fun UVIndexBoxPreview() {
    MyAppTheme {
        Surface {
            UVIndexBox(
                uvIndex = UVIndex(indexPoint = 0, status = "Low\nFor rest of the day"),
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.normal_margin))
                    .height(dimensionResource(id = R.dimen.weather_information_box_height))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.weather_information_box_corner_shape)))
                    .background(MaterialTheme.colors.onSurface)
                    .padding(dimensionResource(id = R.dimen.normal_padding))
            )
        }
    }
}
