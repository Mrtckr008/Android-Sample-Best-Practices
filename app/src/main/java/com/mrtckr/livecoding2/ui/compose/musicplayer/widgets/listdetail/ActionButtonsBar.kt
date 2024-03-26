package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.DynamicAsyncImage

@Composable
fun ActionButtonsBar(listIconUrl: String, onClickToPlay: () -> Unit) {
    Row(modifier = Modifier.padding(8.dp)) {
        DynamicAsyncImage(
            imageUrl = listIconUrl,
            contentDescription = null,
            modifier = Modifier.size(width = 35.dp, height = 55.dp)
        )
        IconButtons(
            icons = listOf(
                Icons.Filled.AddCircleOutline to "AddIcon",
                Icons.Filled.Download to "DownloadIcon",
                Icons.Filled.SettingsEthernet to "CoverIcon"
            ), modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButtons(
            icons = listOf(
                Icons.Filled.Shuffle to "ShuffleIcon"
            ), modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterVertically)
        )
        PlayButton(onClick = onClickToPlay)
    }
}

@Composable
private fun IconButtons(icons: List<Pair<ImageVector, String?>>, modifier: Modifier = Modifier) {
    icons.forEach { (icon, testTag) ->
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = modifier
                .padding(6.dp)
                .testTag(testTag ?: "unknownTag")
        )
    }
}

@Composable
private fun PlayButton(onClick: () -> Unit) {
    Icon(
        imageVector = Icons.Filled.PlayCircle,
        tint = Color.White,
        modifier = Modifier
            .size(50.dp)
            .testTag("PlayIcon")
            .clickable { onClick() },
        contentDescription = null
    )
}

@Preview(device = "id:Nexus 10")
@Composable
fun ActionButtonsBarTabletPreview() {
    MyAppTheme {
        ActionButtonsBar("example", { })
    }
}
