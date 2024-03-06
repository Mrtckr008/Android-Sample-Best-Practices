package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding.data.model.musicplayer.SongListItem
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.DynamicAsyncImage

@Composable
fun SongListItem(song: SongListItem) {
    Column {
        Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            DynamicAsyncImage(
                imageUrl = song.iconUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column {
                Text(
                    text = song.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .testTag("ListSongName"),
                    color = Color.LightGray,
                    fontSize = 15.sp
                )
                Text(
                    text = song.singer,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth(),
                    color = Color.LightGray,
                    fontSize = 12.sp
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 8.dp),
            thickness = dimensionResource(id = R.dimen.divider_height),
            color = Color.DarkGray
        )
    }

}

@Preview
@Composable
fun SongItemListPreview() {
    MyAppTheme {
        LazyColumn {
            items(songListItem.playlistList[1].playlistList[0].songList) { song ->
                SongListItem(song = song)
            }
        }
    }
}
