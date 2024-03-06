package com.mrtckr.livecoding2.navigation

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoActivityResumedException
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding2.MainActivity
import com.mrtckr.livecoding2.ui.compose.common.Constants.MUSIC_PLAYER
import com.mrtckr.livecoding2.ui.compose.common.Constants.WEATHER
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule(order = 3)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigateToMusicPlayerAndBack() {
        composeTestRule.apply {
            onNodeWithText(MUSIC_PLAYER).performClick()
            onNodeWithTag("MusicPlayerSurface").assertExists()

            onNodeWithText(WEATHER).performClick()
            onNodeWithText(mockWeatherData.cityName).assertExists()
        }
    }

    @Test(expected = NoActivityResumedException::class)
    fun navigateToMusicPlayerAndBackAndQuitApp() {
        composeTestRule.apply {
            onNodeWithText(MUSIC_PLAYER).performClick()
            onNodeWithTag("MusicPlayerSurface").assertExists()

            onNodeWithText(WEATHER).performClick()
            onNodeWithText(mockWeatherData.cityName).assertExists()
            Espresso.pressBack()
        }
    }

    @Test
    fun navigateToMusicPlayerThenMusicDetail() {
        composeTestRule.apply {
            onNodeWithText(MUSIC_PLAYER).performClick()
            onNodeWithTag("MusicPlayerSurface").assertExists()

            onNodeWithText(songListItem.playlistList.first().title).performClick()
            composeTestRule.onNodeWithTag("BackButton").isDisplayed()
        }
    }
}
