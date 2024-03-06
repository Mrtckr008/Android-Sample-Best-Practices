package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrtckr.livecoding2.ui.compose.common.pxToDp
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme

@Composable
fun InformationBar(
    listTitle: String,
    userFullName: String,
    context: Context,
    scrollableWidgetBounds: MutableState<Float?>
) {
    Text(text = listTitle,
        fontSize = 12.sp,
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                val toDp = pxToDp(context = context, coordinates.boundsInRoot().top)
                scrollableWidgetBounds.value = toDp
            }.testTag("ListTitleText"))
    Row {
        Icon(
            imageVector = Icons.Filled.LibraryMusic, tint = Color.White, contentDescription = null
        )
        Text(
            text = "Created by AI for $userFullName",
            fontSize = 12.sp,
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .testTag("InformationBarOfUser")
        )
    }
    Text(
        text = "15.566 likes * 2h 44m",
        color = Color.LightGray,
        fontSize = 12.sp,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun InformationBarPreview() {
    MyAppTheme {
        Column {
            InformationBar(
                listTitle = "Eric Clapton top 10",
                context = LocalContext.current,
                userFullName = "Murat Cakir",
                scrollableWidgetBounds = remember { mutableStateOf(1f) })
        }
    }
}
