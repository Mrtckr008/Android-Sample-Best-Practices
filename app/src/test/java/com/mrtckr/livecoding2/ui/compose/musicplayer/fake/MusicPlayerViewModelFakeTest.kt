package com.mrtckr.livecoding2.ui.compose.musicplayer.fake

import com.mrtckr.livecoding.data.datasource.musicplayer.fake.FakePlaylistListDataSource
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.MainCoroutineRule
import com.mrtckr.livecoding2.ui.compose.musicplayer.MusicPlayerViewModel
import com.mrtckr.livecoding2.ui.compose.musicplayer.SongListDataUiState
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MusicPlayerViewModelFakeTest {

    @get:Rule
    var coroutinesTestRule = MainCoroutineRule()

    private lateinit var viewModel: MusicPlayerViewModel
    private lateinit var fakeDataSource: FakePlaylistListDataSource

    @Before
    fun setUp() {
        fakeDataSource = FakePlaylistListDataSource()
        viewModel = MusicPlayerViewModel(mock(), fakeDataSource)
    }

    @Test
    fun `songListData emits Success state with empty list when updated with empty data`() = runBlockingTest {
        fakeDataSource.updateSongListData(PlaylistListEntity(emptyList()))
        val state = viewModel.songListData.first()
        assertTrue(state is SongListDataUiState.Success && state.playlistListEntity.playlistList.isEmpty())
    }

    @Test
    fun `songListData emits Success state with correct data with collectLatest`() =
        runBlockingTest {
            val job = launch {
                viewModel.songListData.collectLatest { songListDataState ->
                    if (songListDataState is SongListDataUiState.Success) {
                        Assert.assertTrue(songListDataState.playlistListEntity.playlistList.isNotEmpty())
                        this.cancel()
                    }
                }
            }
            job.join()
            job.cancelAndJoin()
        }

    @Test
    fun `songListData is updated when updateSongListData is called`() = runBlockingTest {
        val testPlaylist = PlaylistListEntity(songListItem.playlistList)
        fakeDataSource.updateSongListData(testPlaylist)
        val state = viewModel.songListData.first()
        assertTrue(state is SongListDataUiState.Success && state.playlistListEntity == testPlaylist)
    }
}
