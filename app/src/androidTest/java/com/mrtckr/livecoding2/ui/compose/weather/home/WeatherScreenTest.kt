package com.mrtckr.livecoding2.ui.compose.weather.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.domain.entity.FeltTemperature
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.ForecastHours
import com.mrtckr.livecoding.domain.entity.RainfallForecast
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding.domain.entity.ViewingDistance
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
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

        composeTestRule.onNodeWithText("Istanbul").assertExists()
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

        // Note: It's example to figure it out what is onNodeWithTag for.
        // Checking for video playback in a unit test might not be straightforward.
        // You might need to use a custom VideoPlayerBackground composable that exposes
        // some state for testing, or you could check for the existence of the video player
        // component and its resource ID.
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
        composeTestRule.onNodeWithText("${mockWeatherData.temperature}° | ${mockWeatherData.description}")
            .assertIsDisplayed()
    }


    /*@Test
    fun weatherScreen_ShouldHaveContentDescription_WhenGivenValidWeatherData() {
        composeTestRule.setContent {
            WeatherScreen(weatherData = mockWeatherData, context = LocalContext.current)
        }

        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.)).assertExists()
    }

     */


    companion object {
        private val mockForecastData = arrayListOf(
            Forecast(
                day = "Today",
                temperatureMax = 12,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Friday",
                temperatureMax = 5,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Saturday",
                temperatureMax = 5,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.RAINY
            ), Forecast(
                day = "Sunday",
                temperatureMax = 6,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Tuesday",
                temperatureMax = 4,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Wednesday",
                temperatureMax = 7,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.RAINY
            ), Forecast(
                day = "Thursday",
                temperatureMax = 10,
                temperatureMin = 3,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Friday",
                temperatureMax = 14,
                temperatureMin = 7,
                weatherStatus = WeatherStatus.SUNNY
            ), Forecast(
                day = "Saturday",
                temperatureMax = 15,
                temperatureMin = 8,
                weatherStatus = WeatherStatus.SUNNY
            ), Forecast(
                day = "Sunday",
                temperatureMax = 10,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.RAINY
            ), Forecast(
                day = "Tuesday",
                temperatureMax = 3,
                temperatureMin = -4,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Wednesday",
                temperatureMax = -3,
                temperatureMin = -10,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Thursday",
                temperatureMax = -2,
                temperatureMin = -9,
                weatherStatus = WeatherStatus.SNOWY
            )
        )

        private val mockForecastHours = arrayListOf(
            ForecastHours(
                hour = "14", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "15", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "16", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "17", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "18", temperature = 6, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "19", temperature = 5, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "20", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHours(
                hour = "21", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHours(
                hour = "22", temperature = 3, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHours(
                hour = "23", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "00", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "01", temperature = 0, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "02", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "03", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "04", temperature = -2, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "05", temperature = -3, weatherStatus = WeatherStatus.SNOWY,
            )
        )

        val mockWeatherData = WeatherData(
            cityName = "Istanbul",
            "Cloudy",
            forecast = mockForecastData,
            temperature = 8,
            temperatureMax = 12,
            temperatureMin = 0,
            uvIndex = UVIndex(
                indexPoint = 0, status = "Low\nFor rest of the day"
            ),
            rainfallForecast = RainfallForecast(
                index = "0 mm",
                description = "In the last 24 hours\nNo rain is expected in the next 10 days."
            ),
            feltTemperature = FeltTemperature(
                degree = 2, description = "The wind feels colder"
            ),
            forecastHours = mockForecastHours,
            viewingDistance = ViewingDistance(
                visibleDistance = "25 km", description = "It's clear now"
            )
        )
    }
}
