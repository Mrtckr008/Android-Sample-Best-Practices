package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mrtckr.livecoding.domain.entity.musicplayer.MediaPlayerState
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.DynamicAsyncImage
import com.mrtckr.livecoding2.ui.compose.musicplayer.service.MusicPlayerService

@Composable
fun MusicPlayerBottomWidget(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    singer: String,
    serviceBinder: MusicPlayerService.MusicServiceBinder?,
    onPlayPauseClicked: (action: String) -> Unit
) {
    val playerState by serviceBinder?.service?.mediaPlayerManager?.playerState?.collectAsStateWithLifecycle(
        MediaPlayerState.STOPPED
    ) ?: remember { mutableStateOf(MediaPlayerState.STOPPED) }
    val currentPosition by serviceBinder?.service?.mediaPlayerManager?.currentPosition?.collectAsStateWithLifecycle(
        0
    ) ?: remember { mutableIntStateOf(0) }
    val totalTime = serviceBinder?.service?.mediaPlayerManager?.duration?.toFloat() ?: 1f
    val currentProgress = currentPosition / totalTime

    Box(modifier = modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)) {
        Row(modifier = Modifier.fillMaxSize()) {
            DynamicAsyncImage(
                imageUrl = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = title, color = Color.White)
                Text(text = singer, color = Color.LightGray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = if (playerState == MediaPlayerState.PLAYING) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                contentDescription = stringResource(id = R.string.content_description),
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        val action = if (playerState == MediaPlayerState.PLAYING) {
                            MusicPlayerService.ACTION_PAUSE
                        } else {
                            MusicPlayerService.ACTION_PLAY
                        }
                        onPlayPauseClicked(action)
                    },
                tint = Color.White,
            )
        }
        LinearProgressIndicator(
            progress = { currentProgress },
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .padding(horizontal = 8.dp)
                .align(Alignment.BottomCenter),
            color = Color.White,
            trackColor = Color.DarkGray,
        )
    }
}


@Preview
@Composable
fun MusicPlayerWidgetPreview() {
    MyAppTheme {
        Box {
            MusicPlayerBottomWidget(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 70.dp)
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.onTertiary)
                .fillMaxWidth()
                .height(70.dp),
                imageUrl = "",
                title = "Come on, Let's Go",
                singer = "Ritchie Valens",
                serviceBinder = null,
                onPlayPauseClicked = {})
        }
    }
}
