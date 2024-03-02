package com.mrtckr.livecoding2.ui.compose.musicplayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.data.datasource.musicplayer.PlaylistListRepository
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding.domain.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicPlayerViewModel @Inject constructor(
    getUserDataUseCase: GetUserDataUseCase,
    private val playlistListService: PlaylistListRepository,
) : ViewModel() {

    val userData: StateFlow<UserDataUiState> =
        getUserDataUseCase.invoke().map(UserDataUiState::Success).stateIn(
            initialValue = UserDataUiState.Loading,
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
        )

    val songListData: StateFlow<SongListDataUiState> =
        playlistListService.songData.map(SongListDataUiState::Success).stateIn(
            initialValue = SongListDataUiState.Loading,
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
        )


    fun updateSongList(playlistListEntity: PlaylistListEntity) {
        viewModelScope.launch {
            playlistListService.updateSongListData(playlistListEntity)
        }
    }
}

sealed interface UserDataUiState {
    data object Loading : UserDataUiState

    data class Success(
        val userData: User,
    ) : UserDataUiState
}

sealed interface SongListDataUiState {
    data object Loading : SongListDataUiState

    data class Success(
        val playlistListEntity: PlaylistListEntity,
    ) : SongListDataUiState
}
