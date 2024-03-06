package com.mrtckr.livecoding2.ui.compose.weather

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding2.ui.compose.weather.widgets.WeatherScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun weatherScreen_ShouldDisplayWeatherData_WhenGivenValidWeatherData() {
        composeTestRule.setContent {
            WeatherScreen(weatherData = mockWeatherData, context = LocalContext.current)
        }

        composeTestRule.onNodeWithText(mockWeatherData.cityName).assertExists()
        composeTestRule.onNodeWithText("Cloudy").assertExists()
    }

    @Test
    fun weatherScreen_ShouldBeScrollable() {
        composeTestRule.setContent {
            WeatherScreen(weatherData = mockWeatherData, context = LocalContext.current)
        }

        composeTestRule.onNodeWithText("The wind feels colder").performScrollTo()
        composeTestRule.onNodeWithText("Felt Temperature").assertIsDisplayed()
    }

    @Test
    fun weatherScreen_ShouldDisplayExpandedDescriptionTextWithTag() {
        composeTestRule.setContent {
            WeatherScreen(weatherData = mockWeatherData, context = LocalContext.current)
        }
        composeTestRule.onNodeWithTag("ExpandedDescriptionText").assertExists()
    }

    @Test
    fun weatherScreen_ShouldDisplayNecessaryWidgetsAfterScrollToBottom() {
        composeTestRule.setContent {
            WeatherScreen(weatherData = mockWeatherData, context = LocalContext.current)
        }

        composeTestRule.onNodeWithText("Hourly Forecast").assertIsDisplayed()
        composeTestRule.onNodeWithText("Tod").assertIsDisplayed()
        composeTestRule.onNodeWithText("Open on Map").performScrollTo()
        composeTestRule.onNodeWithText("Rainfall Map").assertIsDisplayed()
        composeTestRule.onNodeWithText("The wind feels colder").assertIsDisplayed()
    }

    @Test
    fun weatherScreen_ShouldScrollAnimationExecute_AfterScrolls() {
        composeTestRule.setContent {
            WeatherScreen(weatherData = mockWeatherData, context = LocalContext.current)
        }

        composeTestRule.onNodeWithText("Cloudy").assertIsDisplayed()
        composeTestRule.onAllNodesWithText("Fri")[1].performScrollTo()
        composeTestRule.onAllNodesWithText("Fri")[1].performClick()
        composeTestRule.onNodeWithText("${mockWeatherData.temperature}° | ${mockWeatherData.description}")
            .assertIsDisplayed()
    }
}
