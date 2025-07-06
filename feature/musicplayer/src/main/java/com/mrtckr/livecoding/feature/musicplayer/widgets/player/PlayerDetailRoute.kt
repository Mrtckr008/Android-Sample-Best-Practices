package com.mrtckr.livecoding.feature.musicplayer.widgets.player

import android.content.Context
import android.content.Intent
import android.util.Log
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrtckr.common.ui.Constants
import com.mrtckr.common.ui.dpToPx
import com.mrtckr.common.ui.pxToDp
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.common.ui.widgets.DynamicAsyncImage
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.domain.entity.musicplayer.MediaPlayerState
import com.mrtckr.livecoding.feature.musicplayer.R
import com.mrtckr.livecoding.feature.musicplayer.service.MusicPlayerService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
@Composable
fun PlayerDetailRoute(
    songListId: String,
    serviceBinder: MusicPlayerService.MusicServiceBinder?,
    context: Context = LocalContext.current,
    sheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope,
    bottomSheetWidgetBounds: MutableState<Float?>
) {
    val playlistData = songListItem.playlistList.firstOrNull { it.playlistList.any { playlist -> playlist.id == songListId } }?.playlistList?.firstOrNull { it.id == songListId }

    Log.d(
        "MockUsage",
        "Since the application is a mock application, data is received with the mock, without using the clicked $songListId."
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .onGloballyPositioned { coordinates ->
            val toDp = pxToDp(context = context, coordinates.boundsInRoot().top)

            if (toDp != 0f) {
                bottomSheetWidgetBounds.value = toDp
            }
        }
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.onTertiary,
                    MaterialTheme.colorScheme.onSurface,
                    MaterialTheme.colorScheme.background
                ), startY = Constants.DEFAULT_VALUE, endY = dpToPx(context, 1200f).toFloat()
            )
        )) {
        Column {
            PlayerDetailTopToolbar(sheetState, coroutineScope)
            DynamicAsyncImage(
                imageUrl = playlistData?.iconUrl ?: "",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            SongInformationWidget()
            SliderSeekBar(serviceBinder)
            ActionButtons(serviceBinder)
        }
    }
}

@Composable
fun PlayerDetailTopToolbar(sheetState: ModalBottomSheetState, coroutineScope: CoroutineScope) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(id = R.string.content_description),
            tint = Color.White,
            modifier = Modifier
                .size(60.dp)
                .padding(12.dp)
                .align(Alignment.CenterVertically)
                .testTag("downArrowIcon")
                .clickable {
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                })
        Text(
            text = "Fats Domino Radio",
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterVertically)
                .weight(1f)
                .padding(end = 12.dp),
            color = Color.White
        )
        Icon(
            imageVector = Icons.Filled.MoreHoriz,
            contentDescription = stringResource(id = R.string.content_description),
            tint = Color.White,
            modifier = Modifier
                .size(50.dp)
                .padding(12.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun ActionButtons(serviceBinder: MusicPlayerService.MusicServiceBinder?) {
    val playerState = remember { mutableStateOf(MediaPlayerState.STOPPED) }
    val context = LocalContext.current

    LaunchedEffect(serviceBinder) {
        serviceBinder?.service?.mediaPlayerManager?.playerState?.collect { state ->
            playerState.value = state
        }
    }
    Row(modifier = Modifier.height(110.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Filled.Shuffle,
            contentDescription = stringResource(id = R.string.content_description),
            tint = Color.White,
            modifier = Modifier
                .size(55.dp)
                .padding(12.dp)
                .align(Alignment.CenterVertically)
                .weight(0.7f)
        )
        Icon(
            imageVector = Icons.Filled.SkipPrevious,
            contentDescription = stringResource(id = R.string.content_description),
            tint = Color.White,
            modifier = Modifier
                .size(70.dp)
                .padding(12.dp)
                .align(Alignment.CenterVertically)
                .weight(0.7f)
        )
        AnimatedPlayPauseIcon(playerState, onPlayPauseClicked = { action ->
            val intent = Intent(context, MusicPlayerService::class.java).apply {
                this.action = action
            }
            context.startService(intent)
        })
        Icon(
            imageVector = Icons.Filled.SkipNext,
            contentDescription = stringResource(id = R.string.content_description),
            tint = Color.White,
            modifier = Modifier
                .size(70.dp)
                .padding(12.dp)
                .align(Alignment.CenterVertically)
                .weight(0.7f)
        )
        Icon(
            imageVector = Icons.Filled.Replay,
            contentDescription = stringResource(id = R.string.content_description),
            tint = Color.White,
            modifier = Modifier
                .size(55.dp)
                .padding(12.dp)
                .align(Alignment.CenterVertically)
                .weight(0.7f)
        )
    }
}

@Preview(device = "id:pixel_5")
@Composable
fun SongInformationWidgetPreview() {
    MyAppTheme {
        SongInformationWidget()
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

@Preview(device = "id:pixel_5")
@Composable
fun SliderSeekBarPreview() {
    MyAppTheme {
        SliderSeekBar(null)
    }
}

@Preview(device = "id:pixel_5")
@Composable
fun ActionButtonsPreview() {
    MyAppTheme {
        ActionButtons(null)
    }
}
