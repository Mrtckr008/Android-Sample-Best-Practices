package com.mrtckr.livecoding2.screenshot

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.mrtckr.livecoding.domain.entity.weather.OverlapCurrentInformationWidget
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.weather.extensions.GradientLineBar
import com.mrtckr.livecoding2.ui.compose.weather.extensions.TemperatureBarChart
import com.mrtckr.livecoding2.ui.compose.weather.extensions.WeatherDataPrivacyInformation
import com.mrtckr.livecoding2.ui.compose.weather.extensions.WeatherMapBox
import com.mrtckr.livecoding2.ui.compose.weather.widgets.SectionTabBarTitle
import com.mrtckr.livecoding2.ui.compose.weather.widgets.WeatherScreen
import com.mrtckr.livecoding2.ui.compose.weather.widgets.bottominfo.BottomToolbar
import com.mrtckr.livecoding2.ui.compose.weather.widgets.box.WeatherInformationBox
import com.mrtckr.livecoding2.ui.compose.weather.widgets.currentinfo.CurrentInformationWidget
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class HomeScreenScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        renderingMode = SessionParams.RenderingMode.SHRINK, deviceConfig = DeviceConfig.PIXEL_5
    )

    @Test
    fun weatherScreen_SnapshotWeatherScreen() {
        paparazzi.snapshot {
            MyAppTheme {
                val scrollState = rememberScrollState()
                runBlocking {
                    scrollState.scrollTo(scrollState.maxValue)
                }

                WeatherScreen(mockWeatherData, LocalContext.current)
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
                        overlapTemperature = true, overlapDescription = true, overlapCityName = true
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
                    mockWeatherData.cityName
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
}
