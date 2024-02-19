package com.mrtckr.livecoding2.ui.compose.musicplayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MusicPlayer(viewModel: MusicPlayerViewModel = hiltViewModel()) {

    val userData by viewModel.userData.collectAsStateWithLifecycle()

    when (val data = userData) {
        is UserDataUiState.Loading -> {

        }

        is UserDataUiState.Success -> {

        }
    }
}
