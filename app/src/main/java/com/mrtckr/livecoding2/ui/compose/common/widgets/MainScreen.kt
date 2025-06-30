package com.mrtckr.livecoding2.ui.compose.common.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.mrtckr.livecoding2.ui.compose.musicplayer.service.MusicPlayerService
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.MusicPlayerRoute
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicListDetailRoute
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.player.PlayerDetailRoute
import com.mrtckr.livecoding2.ui.compose.notification.NotificationsScreen
import com.mrtckr.livecoding2.ui.compose.weather.widgets.WeatherScreenRoute
import kotlinx.coroutines.launch
import kotlin.math.max

@Composable
fun MainScreen(
    serviceBinder: MusicPlayerService.MusicServiceBinder?
) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()
    val musicPlayerBottomSheetTopPoint = remember { mutableStateOf<Float?>(null) }

    val bottomBarOffset =
        musicPlayerBottomSheetTopPoint.value?.let { top -> max((-top / 1.5f) + 300, 0f) } ?: 0f
    val selectedSongListId = remember { mutableStateOf<String?>(null) }

    val backStack = remember { mutableStateListOf<Screen>(Screen.Home3) }

    Box(Modifier.fillMaxSize()) {
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetShape = RectangleShape,
            sheetContentColor = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
            sheetContent = {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    PlayerDetailRoute(
                        bottomSheetWidgetBounds = musicPlayerBottomSheetTopPoint,
                        serviceBinder = serviceBinder,
                        songListId = selectedSongListId.value.toString(),
                        sheetState = sheetState,
                        coroutineScope = coroutineScope
                    )
                }
            }) {
            Scaffold(
                bottomBar = { Spacer(Modifier.height(75.dp)) }) { padding ->
                Box(Modifier.padding(padding)) {
                    NavDisplay(backStack = backStack, onBack = {
                        if (sheetState.isVisible) {
                            coroutineScope.launch {
                                sheetState.hide()
                            }
                        } else {
                            backStack.removeLastOrNull()
                        }
                    }, entryProvider = entryProvider {
                        entry<Screen.Home3> { WeatherScreenRoute() }
                        entry<Screen.MusicPlayer3> {
                            MusicPlayerRoute { screen -> backStack.add(screen) }
                        }
                        entry<Screen.Notifications3> { NotificationsScreen() }
                        entry<Screen.PlaylistDetail3> { entry ->
                            selectedSongListId.value = entry.songListId
                            MusicListDetailRoute(
                                songListId = entry.songListId,
                                serviceBinder = serviceBinder,
                                sheetState = sheetState,
                                coroutineScope = coroutineScope
                            )
                        }
                    })
                }
            }
        }

        BottomNavigationBar(
            backStack,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .zIndex(1f)
                .graphicsLayer { translationY = bottomBarOffset })
    }
}
