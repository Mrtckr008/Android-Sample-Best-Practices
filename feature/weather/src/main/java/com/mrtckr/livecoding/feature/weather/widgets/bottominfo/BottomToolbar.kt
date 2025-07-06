package com.mrtckr.livecoding.feature.weather.widgets.bottominfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.livecoding.feature.weather.R
import com.mrtckr.livecoding.feature.weather.extensions.WeatherDataPrivacyInformation

@Composable
fun BottomToolbar(cityName: String) {
    Column {
        HorizontalDivider(
            thickness = dimensionResource(id = R.dimen.divider_height), color = Color.Black
        )

        Row {
            Text(
                text = stringResource(R.string.open_with_map),
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.normal_padding))
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                contentDescription = stringResource(id = R.string.content_description),
                tint = Color.Black,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.bottom_information_bar_icon_size))
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.normal_spacer_size)))
        }

        HorizontalDivider(
            thickness = dimensionResource(id = R.dimen.divider_height), color = Color.Black
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.large_spacer_size)))

        Text(
            text = stringResource(R.string.weather, cityName),
            fontSize = dimensionResource(id = R.dimen.xlarge_text).value.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_spacer_size)))

        WeatherDataPrivacyInformation()
    }
}

@Preview(device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun BottomToolbarPreview() {
    MyAppTheme {
        Surface {
            BottomToolbar(mockWeatherData.cityName)
        }
    }
}
