package com.mrtckr.livecoding2.ui.compose.notification

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrtckr.livecoding2.ui.compose.util.dpToPx

@Preview
@Composable
fun NotificationsScreen() {

    val configuration = LocalConfiguration.current
    val screenWidth = dpToPx(LocalContext.current, configuration.screenWidthDp.dp.value)
    val screenHeight = dpToPx(LocalContext.current, configuration.screenHeightDp.dp.value)

    var offset by remember { mutableStateOf(Offset(200f, 200f)) }
    var color by remember { mutableStateOf(Color.Blue) }
    var radius by remember { mutableStateOf(100f) }

    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(
                onDoubleTap = {
                    radius += 20f
                }
            )
        }
        .pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                val newX = (offset.x + dragAmount.x).coerceIn(0f, screenWidth - 2 * radius)
                val newY = (offset.y + dragAmount.y).coerceIn(0f, screenHeight - 2 * radius)
                offset = Offset(newX, newY)
                color = Color(
                    red = (0..255).random(),
                    green = (0..255).random(),
                    blue = (0..255).random()
                )
            }
        }
    ) {
        drawCircle(
            color = color,
            center = offset,
            radius = radius
        )

    }
}
