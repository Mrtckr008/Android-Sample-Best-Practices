package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding.data.model.musicplayer.PlayListDataEntity
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.ui.compose.common.DynamicAsyncImage
import com.mrtckr.livecoding2.ui.compose.util.MyAppTheme

@Composable
fun HorizontalPlayListWidget(playlistListEntity: PlayListDataEntity) {
    Column(modifier = Modifier.padding(bottom = 16.dp, top = 12.dp).testTag("HorizontalPlayListWidget")) {
        Text(
            text = playlistListEntity.title, fontSize = 20.sp, color = Color.White
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(playlistListEntity.playlistList.size) { index ->
                val playlistData = playlistListEntity.playlistList[index]
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .width(170.dp)
                ) {
                    DynamicAsyncImage(
                        imageUrl = playlistData.iconUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .size(170.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Text(
                        text = playlistData.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .heightIn(min = 40.dp),
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HorizontalPlayListWidgetPreview() {
    MyAppTheme {
        HorizontalPlayListWidget(songListItem.playlistList[1])
    }
}
