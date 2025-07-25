package com.mrtckr.livecoding.feature.musicplayer.widgets.listdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrtckr.common.ui.theme.MyAppTheme

@Composable
fun InformationBar(
    listTitle: String, userFullName: String, scrollableWidgetBounds: MutableState<Float?>
) {
    val density = LocalDensity.current

    Text(
        text = listTitle,
        fontSize = 12.sp,
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
            .onGloballyPositioned { coordinates ->
                val toDp = with(density) { coordinates.boundsInRoot().top.toDp() }
                scrollableWidgetBounds.value = toDp.value
            }
            .testTag("ListTitleText"))
    Row(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.LibraryMusic, tint = Color.White, contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Created by AI for $userFullName",
            fontSize = 12.sp,
            color = Color.LightGray,
            modifier = Modifier.testTag("InformationBarOfUser")
        )
    }
    Text(
        text = "15.566 likes * 2h 44m",
        color = Color.LightGray,
        fontSize = 12.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
    )
}

@Preview
@Composable
fun InformationBarPreview() {
    MyAppTheme {
        Column {
            InformationBar(
                listTitle = "Eric Clapton top 10",
                userFullName = "Murat Cakir",
                scrollableWidgetBounds = remember { mutableStateOf(1f) })
        }
    }
}
