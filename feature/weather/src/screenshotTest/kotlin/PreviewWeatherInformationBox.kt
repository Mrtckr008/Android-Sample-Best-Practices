import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.feature.weather.widgets.box.WeatherInformationBox
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun PreviewWeatherInformationBox() {
    MyAppTheme {
        Surface {
            WeatherInformationBox(mockWeatherData)
        }
    }
}