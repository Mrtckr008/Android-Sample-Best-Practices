package com.mrtckr.livecoding2.screenshot

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.mrtckr.livecoding.domain.entity.FeltTemperature
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.ForecastHours
import com.mrtckr.livecoding.domain.entity.OverlapCurrentInformationWidget
import com.mrtckr.livecoding.domain.entity.RainfallForecast
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding.domain.entity.ViewingDistance
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
import com.mrtckr.livecoding2.ui.compose.weather.extensions.GradientLineBar
import com.mrtckr.livecoding2.ui.compose.weather.extensions.TemperatureBarChart
import com.mrtckr.livecoding2.ui.compose.weather.extensions.WeatherDataPrivacyInformation
import com.mrtckr.livecoding2.ui.compose.weather.extensions.WeatherMapBox
import com.mrtckr.livecoding2.ui.compose.weather.home.SectionTabBarTitle
import com.mrtckr.livecoding2.ui.compose.weather.home.WeatherScreen
import com.mrtckr.livecoding2.ui.compose.weather.home.bottominfo.BottomToolbar
import com.mrtckr.livecoding2.ui.compose.weather.home.box.WeatherInformationBox
import com.mrtckr.livecoding2.ui.compose.weather.home.currentinfo.CurrentInformationWidget
import com.mrtckr.livecoding2.ui.compose.weather.util.MyAppTheme
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test


class HomeScreenScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        renderingMode = SessionParams.RenderingMode.SHRINK,
        deviceConfig = DeviceConfig.PIXEL_5
    )

    @Test
    fun weatherScreen_SnapshotWeatherScreen() {
        paparazzi.snapshot {
            MyAppTheme {
                val scrollState = rememberScrollState()
                runBlocking {
                    scrollState.scrollTo(scrollState.maxValue)
                }

                WeatherScreen(mockWeatherData, LocalContext.current, scrollState)
            }
        }
    }

    @Test
    fun weatherScreen_SnapshotSectionTabBarTitle() {
        paparazzi.snapshot {
            MyAppTheme {
                SectionTabBarTitle(
                    1f,
                    200f,
                    200f,
                    200f,
                )
            }
        }
    }

    @Test
    fun weatherScreen_SnapshotCurrentInformationWidget_WhenOverlapAll() {
        paparazzi.snapshot {
            MyAppTheme {
                CurrentInformationWidget(
                    mockWeatherData, OverlapCurrentInformationWidget(
                        overlapTemperature = true,
                        overlapDescription = true,
                        overlapCityName = true
                    )
                )
            }
        }
    }

    @Test
    fun weatherScreen_SnapshotCurrentInformationWidget_WhenNoOverlap() {
        paparazzi.snapshot {
            MyAppTheme {
                CurrentInformationWidget(
                    mockWeatherData, OverlapCurrentInformationWidget(
                        overlapTemperature = false,
                        overlapDescription = false,
                        overlapCityName = false
                    )
                )
            }
        }
    }

    @Test
    fun weatherScreen_SnapshotCurrentInformationWidget_WhenTemperatureOverlap() {
        paparazzi.snapshot {
            MyAppTheme {
                CurrentInformationWidget(
                    mockWeatherData, OverlapCurrentInformationWidget(
                        overlapTemperature = false,
                        overlapDescription = true,
                        overlapCityName = true
                    )
                )
            }
        }
    }

    @Test
    fun weatherScreen_SnapshotWeatherInformationBox() {
        paparazzi.snapshot {
            MyAppTheme {
                WeatherInformationBox(
                    mockWeatherData
                )
            }
        }
    }

    @Test
    fun weatherScreen_BottomToolbar() {
        paparazzi.snapshot {
            MyAppTheme {
                BottomToolbar(
                    "Istanbul"
                )
            }
        }
    }

    @Test
    fun weatherScreen_TemperatureBarChart() {
        paparazzi.snapshot {
            MyAppTheme {
                TemperatureBarChart()
            }
        }
    }

    @Test
    fun weatherScreen_WeatherDataPrivacyInformation() {
        paparazzi.snapshot {
            MyAppTheme {
                WeatherDataPrivacyInformation()
            }
        }
    }

    @Test
    fun weatherScreen_WeatherMapBox() {
        paparazzi.snapshot {
            MyAppTheme {
                WeatherMapBox(remember { mutableStateOf(null) })
            }
        }
    }

    @Test
    fun weatherScreen_GradientLineBar() {
        paparazzi.snapshot {
            MyAppTheme {
                GradientLineBar()
            }
        }
    }

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
