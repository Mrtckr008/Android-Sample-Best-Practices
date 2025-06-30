package com.mrtckr.livecoding2.ui.compose.musicplayer

import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.data.datasource.musicplayer.PlaylistListRepository
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding.domain.usecase.GetUserDataUseCase
import com.mrtckr.livecoding2.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MusicPlayerViewModelTest {

    @get:Rule
    var mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: MusicPlayerViewModel

    private val getUserDataUseCase: GetUserDataUseCase = mockk()

    private val playlistListService: PlaylistListRepository = mockk()

    @Before
    fun setUp() {
        // 1. userData
        coEvery { getUserDataUseCase.invoke() } returns flow {
            emit(
                User(
                    id = "1",
                    iconUrl = "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg",
                    name = "Murat Cakir",
                    favoriteList = listOf()
                )
            )
        }

        every { playlistListService.songData } returns flow {
            emit(PlaylistListEntity(songListItem.playlistList))
        }

        coJustRun { playlistListService.updateSongListData(any()) }

        viewModel = MusicPlayerViewModel(getUserDataUseCase, playlistListService)
    }

    @After
    fun tearDown() {
        viewModel.viewModelScope.cancel()
    }

    @Test
    fun `userData emits Loading state`() = runTest {
        val userDataState = viewModel.userData.value
        assertTrue(userDataState is UserDataUiState.Loading)
    }

    @Test
    fun `songListData emits Loading state`() = runTest {
        val songListData = viewModel.songListData.value
        assertTrue(songListData is SongListDataUiState.Loading)
    }

    @Test
    fun `userData emits Success state with correct data`() = runTest {
        val emission = viewModel.userData.first { it is UserDataUiState.Success }
        assertTrue(emission is UserDataUiState.Success && emission.userData.name == "Murat Cakir")
    }

    @Test
    fun `songListData emits Success state with correct data`() = runTest {
        val emission = viewModel.songListData.first { it is SongListDataUiState.Success }
        assertTrue(emission is SongListDataUiState.Success && emission.playlistListEntity.playlistList.isNotEmpty())
    }

    @Test
    fun `songListData emits Success state with correct data with collectLatest`() = runTest {
        val job = launch {
            viewModel.songListData.collectLatest { songListDataState ->
                if (songListDataState is SongListDataUiState.Success) {
                    assertTrue(songListDataState.playlistListEntity.playlistList.isNotEmpty())
                    this.cancel()
                }
            }
        }
        job.join()
        job.cancelAndJoin()
    }

    @Test
    fun `updateSongList calls updateSongListData in PlaylistListService`() =
        runTest(mainDispatcherRule.dispatcher) {

            val playlist = PlaylistListEntity(songListItem.playlistList)

            viewModel.updateSongList(playlist)

            runCurrent()

            coVerify(exactly = 1) {
                playlistListService.updateSongListData(playlist)
            }

            viewModel.viewModelScope.cancel()
        }

}
