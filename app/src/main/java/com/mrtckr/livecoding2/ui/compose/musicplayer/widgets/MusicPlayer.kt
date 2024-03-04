package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.ui.compose.common.Constants.GRID_LIKED_LIST
import com.mrtckr.livecoding2.ui.compose.common.Constants.HORIZONTAL_PLAYLIST
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.LoadingScreen
import com.mrtckr.livecoding2.ui.compose.musicplayer.MusicPlayerViewModel
import com.mrtckr.livecoding2.ui.compose.musicplayer.SongListDataUiState
import com.mrtckr.livecoding2.ui.compose.musicplayer.UserDataUiState

@Composable
fun MusicPlayerRoute(
    viewModel: MusicPlayerViewModel = hiltViewModel(),
    navigateToPlaylistDetail: (String) -> Unit
) {
    val userData by viewModel.userData.collectAsStateWithLifecycle()
    val playListData by viewModel.songListData.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.updateSongList(songListItem)
    }

    Scaffold(topBar = {
        if (userData is UserDataUiState.Success) {
            TopWidgetTopBar(userData as UserDataUiState.Success)
        }
    }) { paddingValues ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .testTag("MusicPlayerSurface")
        ) {
            MusicPlayer(playListData, navigateToPlaylistDetail)
        }
    }
}

@Composable
fun MusicPlayer(
    playListData: SongListDataUiState,
    navigateToPlaylistDetailWithId: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 80.dp)
    ) {
        when (playListData) {
            is SongListDataUiState.Success -> {
                items(playListData.playlistListEntity.playlistList) { playlist ->
                    when (playlist.type) {
                        HORIZONTAL_PLAYLIST -> HorizontalPlayListWidget(
                            playlistListEntity = playlist,
                            onClick = { playlistData ->
                                navigateToPlaylistDetailWithId(playlistData.id)
                            })

                        GRID_LIKED_LIST -> PlaylistListWidget(
                            playlistListEntity = playlist,
                            onClick = { playlistData ->
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

            }
        )
    }
}
