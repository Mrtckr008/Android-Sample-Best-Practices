package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.data.testing.songListItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlaylistListWidgetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun playlistListWidget_displaysCorrectData() {
        val testPlaylist = songListItem.playlistList[0]

        composeTestRule.setContent {
            PlaylistListWidget(playlistListEntity = testPlaylist)
        }

        composeTestRule.onNodeWithTag("PlaylistListWidget").assertIsDisplayed()

        testPlaylist.playlistList.forEach { playlistData ->
            composeTestRule.onAllNodesWithText(playlistData.title).assertCountEquals(1)
        }
    }
}
