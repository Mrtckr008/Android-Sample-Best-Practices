import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.feature.weather.widgets.bottominfo.BottomToolbar
import theme.MyAppTheme

@PreviewTest
@Preview(device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun BottomToolbarPreview() {
    MyAppTheme {
        Surface {
            BottomToolbar(mockWeatherData.cityName)
        }
    }
}
