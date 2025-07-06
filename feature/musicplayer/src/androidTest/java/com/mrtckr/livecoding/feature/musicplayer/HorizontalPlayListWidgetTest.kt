package com.mrtckr.livecoding.feature.musicplayer

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.feature.musicplayer.widgets.HorizontalPlayListWidget
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HorizontalPlayListWidgetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun horizontalPlayListWidget_displaysCorrectData() {
        val testPlaylist = songListItem.playlistList[1]

        composeTestRule.setContent {
            HorizontalPlayListWidget(playlistListEntity = testPlaylist) {

            }
        }

        composeTestRule.onNodeWithText("Eric Clapton, Albert Collins, The Rolling Stone")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(testPlaylist.playlistList.first().title).assertIsDisplayed()
    }
}
