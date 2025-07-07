import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.weather.widgets.SectionTabBarTitle
import theme.MyAppTheme
import androidx.compose.material3.Surface

@PreviewTest
@Preview
@Composable
fun PreviewSectionTabBarTitle() {
    MyAppTheme {
        Surface {
            SectionTabBarTitle(1f, 1f, 10f, 100f)
        }
    }
}