package com.mrtckr.livecoding.feature.musicplayer.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.common.ui.widgets.DynamicAsyncImage
import com.mrtckr.livecoding.data.model.musicplayer.PlayListDataEntity
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistEntity
import com.mrtckr.livecoding.data.testing.songListItem

@Composable
fun PlaylistListWidget(playlistListEntity: PlayListDataEntity, onClick: (PlaylistEntity) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .height(250.dp)
            .testTag("PlaylistListWidget")
    ) {
        items(items = playlistListEntity.playlistList) { playlistData ->
            Surface(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp)
                    .clickable {
                        onClick(playlistData)
                    },
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.onSurface,
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxSize()
                ) {
                    DynamicAsyncImage(
                        imageUrl = playlistData.iconUrl,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp),
                    )
                    Text(
                        text = playlistData.title,
                        color = Color.White,
                        maxLines = 2,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.dp, end = 8.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PlaylistListWidgetPreview() {
    MyAppTheme {
        Surface {
            PlaylistListWidget(songListItem.playlistList[0]) {}
        }
    }
}
