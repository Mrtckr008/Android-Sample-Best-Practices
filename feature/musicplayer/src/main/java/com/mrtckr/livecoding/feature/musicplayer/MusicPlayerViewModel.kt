package com.mrtckr.livecoding.feature.musicplayer

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.data.datasource.musicplayer.PlaylistListRepository
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListErrorItem
import com.mrtckr.livecoding.data.testing.songListItem
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
    data object Error : UserDataUiState
    data class Success(
        val userData: User,
    ) : UserDataUiState
}

sealed interface SongListDataUiState {
    data object Loading : SongListDataUiState
    data object Error : SongListDataUiState
    data class Success(
        val playlistListEntity: PlaylistListEntity,
    ) : SongListDataUiState
}

class SongListDataUiStateProvider: PreviewParameterProvider<SongListDataUiState> {
    override val values: Sequence<SongListDataUiState> = sequenceOf(
        SongListDataUiState.Loading,
        SongListDataUiState.Success(playlistListEntity = songListItem),
        SongListDataUiState.Success(playlistListEntity = songListErrorItem),
        SongListDataUiState.Error
    )
}

class UserDataUiStateProvider: PreviewParameterProvider<UserDataUiState> {
    override val values: Sequence<UserDataUiState> = sequenceOf(
        UserDataUiState.Loading,
        UserDataUiState.Success(userData = User("1", "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg", "Murat Çakır", emptyList())),
        UserDataUiState.Success(userData = User("2", "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg", "Liza Burova", emptyList())),
        UserDataUiState.Error
    )
}
