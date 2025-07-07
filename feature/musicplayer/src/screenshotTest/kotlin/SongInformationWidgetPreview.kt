import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.musicplayer.widgets.player.SongInformationWidget
import theme.MyAppTheme

@PreviewTest
@Preview(device = "id:pixel_5")
@Composable
fun SongInformationWidgetPreview() {
    MyAppTheme {
        SongInformationWidget()
    }
}