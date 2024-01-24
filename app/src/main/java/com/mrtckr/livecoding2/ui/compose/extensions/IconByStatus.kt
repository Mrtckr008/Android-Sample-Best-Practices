package com.mrtckr.livecoding2.ui.compose.extensions

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.mrtckr.livecoding.domain.entity.WeatherStatus
import com.mrtckr.livecoding2.R

@Composable
fun IconByStatus(status: WeatherStatus, modifier: Modifier) {
    when (status) {
        WeatherStatus.RAINY -> {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.rain_icon),
                contentDescription = stringResource(id = R.string.content_description),
                modifier = modifier.size(dimensionResource(id = R.dimen.weather_status_icon_size)),
                tint = Color.White
            )
        }

        WeatherStatus.SNOWY -> {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.snow),
                contentDescription = stringResource(id = R.string.content_description),
                tint = Color.White,
                modifier = modifier.size(dimensionResource(id = R.dimen.weather_status_icon_size))
            )
        }

        WeatherStatus.SUNNY -> {
            Icon(
                imageVector = Icons.Filled.WbSunny,
                contentDescription = stringResource(id = R.string.content_description),
                tint = Color.Yellow,
                modifier = modifier.size(dimensionResource(id = R.dimen.weather_status_icon_size))
            )

        }

        else -> {
            Icon(
                imageVector = Icons.Filled.WbCloudy,
                contentDescription = stringResource(id = R.string.content_description),
                tint = Color.White,
                modifier = modifier.size(dimensionResource(id = R.dimen.weather_status_icon_size))
            )
        }
    }
}
