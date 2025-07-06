import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.musicplayer.widgets.player.SliderSeekBar
import theme.MyAppTheme

@PreviewTest
@Preview()
@Composable
fun SlideSeekbarScreenShot() {
    MyAppTheme {
        SliderSeekBar(null)
    }
}
