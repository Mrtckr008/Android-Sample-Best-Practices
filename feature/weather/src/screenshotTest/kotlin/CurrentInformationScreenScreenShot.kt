import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.domain.entity.weather.FeltTemperature
import com.mrtckr.livecoding.domain.entity.weather.OverlapCurrentInformationWidget
import com.mrtckr.livecoding.domain.entity.weather.RainfallForecast
import com.mrtckr.livecoding.domain.entity.weather.UVIndex
import com.mrtckr.livecoding.domain.entity.weather.ViewingDistance
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.feature.weather.widgets.currentinfo.CurrentInformationWidget
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun CurrentInformationWidgetCollapsedLongTextPreview() {
    MyAppTheme {
        Surface {
            CurrentInformationWidget(
                weatherData = WeatherData(
                    cityName = "Loooong Istanbul Istanbul Istanbul Istanbul",
                    description = "Looooong Cloudy",
                    forecast = arrayListOf(),
                    forecastHours = arrayListOf(),
                    temperature = 123123,
                    temperatureMax = 12,
                    temperatureMin = 0,
                    uvIndex = UVIndex(
                        indexPoint = 0, status = ""
                    ),
                    rainfallForecast = RainfallForecast(
                        index = "", description = ""
                    ),
                    feltTemperature = FeltTemperature(
                        degree = 0, description = ""
                    ),
                    viewingDistance = ViewingDistance(
                        visibleDistance = "", description = ""
                    )
                ), overlapCurrentInformationWidget = OverlapCurrentInformationWidget(
                    overlapTemperature = false, overlapDescription = false, overlapCityName = false
                )
            )
        }
    }
}

@PreviewTest
@Preview
@Composable
fun CurrentInformationWidgetExpandedPreview() {
    MyAppTheme {
        Surface {
            CurrentInformationWidget(
                weatherData = WeatherData(
                    cityName = mockWeatherData.cityName,
                    description = "Cloudy",
                    forecast = arrayListOf(),
                    forecastHours = arrayListOf(),
                    temperature = 3,
                    temperatureMax = 0,
                    temperatureMin = 0,
                    uvIndex = UVIndex(
                        indexPoint = 0, status = ""
                    ),
                    rainfallForecast = RainfallForecast(
                        index = "", description = ""
                    ),
                    feltTemperature = FeltTemperature(
                        degree = 0, description = ""
                    ),
                    viewingDistance = ViewingDistance(
                        visibleDistance = "", description = ""
                    )
                ), overlapCurrentInformationWidget = OverlapCurrentInformationWidget(
                    overlapTemperature = true, overlapDescription = true, overlapCityName = true
                )
            )
        }
    }
}

@PreviewTest
@Preview(device = "id:Nexus 10")
@Composable
fun CurrentInformationWidgetPartlyExpandedLongTextTabletPreview() {
    MyAppTheme {
        Surface {
            CurrentInformationWidget(
                weatherData = WeatherData(
                    cityName = "Looooooooooooooong Istanbul Istanbul Istanbul Istanbul Istanbul Istanbul",
                    description = "Cloudy",
                    forecast = arrayListOf(),
                    forecastHours = arrayListOf(),
                    temperature = 34250928,
                    temperatureMax = 0,
                    temperatureMin = 0,
                    uvIndex = UVIndex(
                        indexPoint = 0, status = ""
                    ),
                    rainfallForecast = RainfallForecast(
                        index = "", description = ""
                    ),
                    feltTemperature = FeltTemperature(
                        degree = 0, description = ""
                    ),
                    viewingDistance = ViewingDistance(
                        visibleDistance = "", description = ""
                    )
                ), overlapCurrentInformationWidget = OverlapCurrentInformationWidget(
                    overlapTemperature = false, overlapDescription = false, overlapCityName = true
                )
            )
        }
    }
}
