package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.SettingsEthernet
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.DynamicAsyncImage

@Composable
fun ActionButtonsBar(listIconUrl: String) {
    Row {
        DynamicAsyncImage(
            imageUrl = listIconUrl,
            contentDescription = null,
            modifier = Modifier
                .width(35.dp)
                .height(55.dp),
        )
        Icon(
            imageVector = Icons.Filled.AddCircleOutline,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .width(40.dp)
                .align(Alignment.CenterVertically)
        )
        Icon(
            imageVector = Icons.Filled.Download,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .width(40.dp)
                .align(Alignment.CenterVertically)
        )
        Icon(
            imageVector = Icons.Filled.SettingsEthernet,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .width(40.dp)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.Shuffle,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .width(40.dp)
                .align(Alignment.CenterVertically)
        )
        Icon(
            imageVector = Icons.Filled.PlayCircle,
            tint = Color.White,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterVertically),
            contentDescription = null
        )
    }
}

@Preview(device = "id:Nexus 10")
@Composable
fun ActionButtonsBarTabletPreview() {
    MyAppTheme {
        ActionButtonsBar("example")
    }
}
