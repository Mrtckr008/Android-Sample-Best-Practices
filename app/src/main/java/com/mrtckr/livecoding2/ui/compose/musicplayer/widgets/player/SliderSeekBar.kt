package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding2.ui.compose.common.formatTime
import com.mrtckr.livecoding2.ui.compose.musicplayer.service.MusicPlayerService
import kotlinx.coroutines.launch

@Composable
fun SliderSeekBar(serviceBinder: MusicPlayerService.MusicServiceBinder?) {
    val coroutineScope = rememberCoroutineScope()
    val currentPosition =
        serviceBinder?.service?.mediaPlayerManager?.currentPosition?.collectAsState(initial = 0)?.value
            ?: 0
    val totalTime = serviceBinder?.service?.mediaPlayerManager?.duration?.toFloat() ?: 1f

    Column(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 12.dp)
    ) {
        val leftTime = formatTime(currentPosition.toFloat())
        val rightTime = formatTime(totalTime - currentPosition)

        Slider(
            value = currentPosition / totalTime, onValueChange = { newPosition ->
                coroutineScope.launch {
                    val newTime = (newPosition * totalTime).toInt()
                    serviceBinder?.service?.seekTo(newTime)
                }
            }, valueRange = 0f..1f, modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = leftTime,
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = rightTime,
                modifier = Modifier.padding(end = 8.dp),
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}
