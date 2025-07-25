package com.mrtckr.livecoding.feature.musicplayer.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mrtckr.common.ui.Constants.CATEGORIES
import com.mrtckr.common.ui.Constants.GRID_LIKED_LIST
import com.mrtckr.common.ui.Constants.HORIZONTAL_PLAYLIST
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.common.ui.widgets.LoadingScreen
import com.mrtckr.common.ui.widgets.Screen
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.feature.musicplayer.MusicPlayerViewModel
import com.mrtckr.livecoding.feature.musicplayer.SongListDataUiState
import com.mrtckr.livecoding.feature.musicplayer.UserDataUiState

@Composable
fun MusicPlayerRoute(
    viewModel: MusicPlayerViewModel = hiltViewModel(),
    onNavigate: (Screen) -> Unit
) {
    val userData by viewModel.userData.collectAsStateWithLifecycle()
    val playListData by viewModel.songListData.collectAsStateWithLifecycle()
    var selectedCategory by rememberSaveable { mutableStateOf(CATEGORIES.first()) }

    LaunchedEffect(Unit) {
        viewModel.updateSongList(songListItem)
    }

    Scaffold(topBar = {
        if (userData is UserDataUiState.Success) {
            TopWidgetTopBar(
                userData as UserDataUiState.Success,
                selectedCategory
            ) { selectedCategory = it }
        }
    }) { paddingValues ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .testTag("MusicPlayerSurface")
        ) {
            MusicPlayer(playListData) {
                onNavigate(Screen.PlaylistDetail(it))
            }
        }
    }
}

@Composable
fun MusicPlayer(
    playListData: SongListDataUiState, navigateToPlaylistDetailWithId: (String) -> Unit
) {
    LazyColumn {
        when (playListData) {
            is SongListDataUiState.Success -> {
                items(playListData.playlistListEntity.playlistList) { playlist ->
                    when (playlist.type) {
                        HORIZONTAL_PLAYLIST -> HorizontalPlayListWidget(
                            playlistListEntity = playlist, onClick = { playlistData ->
                                navigateToPlaylistDetailWithId(playlistData.id)
                            })

                        GRID_LIKED_LIST -> PlaylistListWidget(
                            playlistListEntity = playlist, onClick = { playlistData ->
                                navigateToPlaylistDetailWithId(playlistData.id)
                            })
                    }
                }
            }

            else -> {
                item { LoadingScreen() }
            }
        }
    }
}

@Preview(device = "spec:parent=Nexus 10,orientation=portrait")
@Composable
fun MusicPlayerPortraitTabletPreview() {
    MyAppTheme {
        MusicPlayer(
            playListData = SongListDataUiState.Success(songListItem),
            navigateToPlaylistDetailWithId = {

            })
    }
}
