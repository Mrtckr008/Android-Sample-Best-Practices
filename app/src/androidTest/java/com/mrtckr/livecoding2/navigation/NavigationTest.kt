package com.mrtckr.livecoding2.navigation

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoActivityResumedException
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding2.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule(order = 3)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigateToDashboardAndBack() {
        composeTestRule.apply {
            onNodeWithText("Music Player").performClick()
            onNodeWithTag("MusicPlayerSurface").assertExists()

            onNodeWithText("Weather").performClick()
            onNodeWithText("Istanbul").assertExists()
        }
    }

    @Test(expected = NoActivityResumedException::class)
    fun navigateToDashboardAndBackAndQuitApp() {
        composeTestRule.apply {
            onNodeWithText("Music Player").performClick()
            onNodeWithTag("MusicPlayerSurface").assertExists()

            onNodeWithText("Weather").performClick()
            onNodeWithText("Istanbul").assertExists()
            Espresso.pressBack()
        }
    }
}
