package com.mrtckr.livecoding2.navigation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding2.MainActivity
import com.mrtckr.common.ui.Constants.MUSIC_PLAYER
import com.mrtckr.common.ui.Constants.WEATHER
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val musicScreenTag = "MusicPlayerSurface"
    private val toolbarTextTag = "ToolbarText"
    private val musicPlayerText = MUSIC_PLAYER
    private val weatherTabText = WEATHER

    @Before
    fun waitForMainScreen() {
        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithText(musicPlayerText).fetchSemanticsNodes().isNotEmpty()
        }
    }

    @Test
    fun navigateToMusicPlayerAndWeatherAndBackToMusic() {
        composeTestRule.onNodeWithText(musicPlayerText).performClick()
        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithTag(musicScreenTag).fetchSemanticsNodes().isNotEmpty()
        }

        composeTestRule.onNodeWithText(weatherTabText).performClick()
        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithText(mockWeatherData.cityName).fetchSemanticsNodes()
                .isNotEmpty()
        }

        Espresso.pressBack()

        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithTag(musicScreenTag).fetchSemanticsNodes().isNotEmpty()
        }
        composeTestRule.onNodeWithTag(musicScreenTag).assertIsDisplayed()
    }

    @Test
    fun navigateToMusicPlayerAndBackToMainWithPressBack() {
        composeTestRule.onNodeWithText(musicPlayerText).performClick()
        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithTag(musicScreenTag).fetchSemanticsNodes().isNotEmpty()
        }

        Espresso.pressBack()

        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithText(musicPlayerText).fetchSemanticsNodes().isNotEmpty()
        }
        composeTestRule.onNodeWithText(musicPlayerText).assertIsDisplayed()
    }

    @Test
    fun navigateToMusicPlayerThenPlaylistDetailAndBackWithPressBack() {
        composeTestRule.onNodeWithText(musicPlayerText).performClick()
        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithTag(musicScreenTag).fetchSemanticsNodes().isNotEmpty()
        }

        val firstTitle = songListItem.playlistList.first().title
        composeTestRule.onNodeWithText(firstTitle).performClick()

        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithTag(toolbarTextTag).fetchSemanticsNodes().isNotEmpty()
        }
        composeTestRule.onNodeWithTag(toolbarTextTag).assertIsDisplayed()
            .assertTextEquals(firstTitle)

        Espresso.pressBack()
        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule.onAllNodesWithTag(musicScreenTag).fetchSemanticsNodes().isNotEmpty()
        }
        composeTestRule.onNodeWithTag(musicScreenTag).assertIsDisplayed()
    }
}
