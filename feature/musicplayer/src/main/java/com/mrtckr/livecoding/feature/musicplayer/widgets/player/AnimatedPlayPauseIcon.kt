package com.mrtckr.livecoding.feature.musicplayer.widgets.player

import android.content.Intent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.livecoding.domain.entity.musicplayer.MediaPlayerState
import com.mrtckr.livecoding.feature.musicplayer.service.MusicPlayerService

@Composable
fun AnimatedPlayPauseIcon(
    playerState: State<MediaPlayerState>, onPlayPauseClicked: (action: String) -> Unit
) {
    AnimatedContent(
        targetState = playerState.value, transitionSpec = {
            if (targetState == MediaPlayerState.PLAYING) {
                fadeIn(animationSpec = tween(durationMillis = 700)) togetherWith fadeOut(
                    animationSpec = tween(
                        durationMillis = 700
                    )
                )
            } else {
                fadeIn(animationSpec = tween(durationMillis = 700)) togetherWith fadeOut(
                    animationSpec = tween(
                        durationMillis = 700
                    )
                )
            }
        }, label = ""
    ) { targetState ->
        val imageVector: ImageVector = if (targetState == MediaPlayerState.PLAYING) {
            Icons.Filled.Pause
        } else {
            Icons.Filled.PlayCircle
        }
        Icon(imageVector = imageVector,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(100.dp)
                .padding(12.dp)
                .clickable {
                    val action = if (playerState.value == MediaPlayerState.PLAYING) {
                        MusicPlayerService.Companion.ACTION_PAUSE
                    } else {
                        MusicPlayerService.Companion.ACTION_PLAY
                    }
                    onPlayPauseClicked(action)
                })
    }
}


@Preview(device = "id:pixel_5")
@Composable
fun AnimatedPlayPauseIconPreview() {
    val context = LocalContext.current
    MyAppTheme {
        AnimatedPlayPauseIcon(
            playerState = remember { mutableStateOf(MediaPlayerState.STOPPED) },
            onPlayPauseClicked = { action ->
                val intent = Intent(context, MusicPlayerService::class.java).apply {
                    this.action = action
                }
                context.startService(intent)
            })
    }
}
