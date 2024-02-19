package com.mrtckr.livecoding2.ui.compose.musicplayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.domain.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MusicPlayerViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase
) : ViewModel() {

    val userData: StateFlow<UserDataUiState> =
        getUserDataUseCase.invoke().map(UserDataUiState::Success).stateIn(
            initialValue = UserDataUiState.Loading,
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
        )
}
