package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.player

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.R

@Composable
fun SongInformationWidget() {
    Row(Modifier.padding(start = 16.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = songListItem.playlistList.first().playlistList.first().songList.first().name,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = 12.dp),
                fontSize = 20.sp,
                color = Color.White
            )
            Text(
                text = songListItem.playlistList.first().playlistList.first().songList.first().singer,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = 12.dp, top = 6.dp),
                color = Color.LightGray
            )
        }
        Icon(
            imageVector = Icons.Filled.AddCircleOutline,
            contentDescription = stringResource(id = R.string.content_description),
            tint = Color.White,
            modifier = Modifier
                .size(50.dp)
                .padding(end = 12.dp)
                .align(Alignment.CenterVertically)
        )
    }
}
