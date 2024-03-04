package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.ui.compose.musicplayer.SongListDataUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MusicPlayerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun musicPlayer_displaysLoadingScreen_whenPlayListDataIsLoading() {
        composeTestRule.setContent {
            MusicPlayer(
                playListData = SongListDataUiState.Loading,
                navigateToPlaylistDetailWithId = {
                    it
                }
            )
        }

        composeTestRule
            .onNodeWithTag("LoadingBox")
            .assertIsDisplayed()
    }

    @Test
    fun musicPlayer_displaysPlaylists_whenPlayListDataIsSuccess() {
        val testPlayListData = SongListDataUiState.Success(
            PlaylistListEntity(
                songListItem.playlistList
            )
        )

        composeTestRule.setContent {
            MusicPlayer(
                playListData = testPlayListData,
                navigateToPlaylistDetailWithId = {

                }
            )
        }

        composeTestRule
            .onAllNodesWithTag("HorizontalPlayListWidget")
            .onFirst()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("PlaylistListWidget")
            .onFirst()
            .assertIsDisplayed()
    }
}
