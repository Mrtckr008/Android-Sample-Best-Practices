package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme

@Composable
fun TopToolbar(
    title: String, animatedAlpha: Float
) {
    val dispatcher = LocalNavigationEventDispatcherOwner.current?.navigationEventDispatcher
    Row {
        IconButton(onClick = {
            dispatcher?.dispatchOnCompleted()
        }) {
            Icon(
                Icons.Filled.ArrowBackIosNew,
                tint = Color.LightGray,
                contentDescription = "null",
                modifier = Modifier.testTag("BackButton")
            )
        }

        Text(
            text = title,
            color = Color.LightGray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .alpha(animatedAlpha)
                .padding(start = 8.dp, end = 32.dp)
                .testTag("ToolbarText")
        )
    }
}

@Preview
@Composable
fun TopToolbarPreview() {
    MyAppTheme {
        Surface {
            TopToolbar("Pink Floyd", 1f)
        }
    }
}
