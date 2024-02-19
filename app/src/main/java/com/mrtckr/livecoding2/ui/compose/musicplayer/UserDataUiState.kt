package com.mrtckr.livecoding2.ui.compose.musicplayer

import com.mrtckr.livecoding.domain.entity.user.User

sealed interface UserDataUiState {
    data object Loading : UserDataUiState

    data class Success(
        val userData: User,
    ) : UserDataUiState
}