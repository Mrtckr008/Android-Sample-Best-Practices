import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import theme.MyAppTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.feature.weather.widgets.list.ForecastWidget

@PreviewTest
@Preview
@Composable
fun PreviewForecastWidget() {
    MyAppTheme {
        Surface {
            val scrollableWidgetBounds = remember { mutableStateOf<Float?>(null) }
            ForecastWidget(mockWeatherData, scrollableWidgetBounds, LocalContext.current)
        }
    }
}