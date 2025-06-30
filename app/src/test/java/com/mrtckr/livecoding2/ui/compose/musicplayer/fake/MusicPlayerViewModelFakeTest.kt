package com.mrtckr.livecoding2.ui.compose.musicplayer.fake

import com.mrtckr.livecoding.data.datasource.musicplayer.fake.FakePlaylistListDataSource
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.MainDispatcherRule
import com.mrtckr.livecoding2.ui.compose.musicplayer.MusicPlayerViewModel
import com.mrtckr.livecoding2.ui.compose.musicplayer.SongListDataUiState
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MusicPlayerViewModelFakeTest {

    @Rule
    @JvmField
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeDataSource: FakePlaylistListDataSource

    @Before
    fun setupDataSource() {
        fakeDataSource = FakePlaylistListDataSource()
    }

    @Test
    fun `songListData emits Success with empty list`() = runTest(mainDispatcherRule.dispatcher) {
        fakeDataSource.updateSongListData(PlaylistListEntity(emptyList()))
        val viewModel = MusicPlayerViewModel(mock(), fakeDataSource)
        val state = viewModel.songListData.first { it is SongListDataUiState.Success }

        assertTrue(
            (state as SongListDataUiState.Success).playlistListEntity.playlistList.isEmpty()
        )
    }

    @Test
    fun `songListData emits Success state with correct data`() = runTest {
        val viewModel = MusicPlayerViewModel(mock(), fakeDataSource)

        val job = launch {
            viewModel.songListData.collectLatest { state ->
                if (state is SongListDataUiState.Success) {
                    assertTrue(state.playlistListEntity.playlistList.isNotEmpty())
                    cancel()
                }
            }
        }

        job.join()
    }

    @Test
    fun `songListData is updated when updateSongListData is called`() =
        runTest(mainDispatcherRule.dispatcher) {
            val viewModel = MusicPlayerViewModel(mock(), fakeDataSource)
            val testPlaylist = PlaylistListEntity(songListItem.playlistList)
            fakeDataSource.updateSongListData(testPlaylist)
            val state = viewModel.songListData.first {
                it is SongListDataUiState.Success
            }
            assertTrue(state is SongListDataUiState.Success && state.playlistListEntity == testPlaylist)
        }
}
