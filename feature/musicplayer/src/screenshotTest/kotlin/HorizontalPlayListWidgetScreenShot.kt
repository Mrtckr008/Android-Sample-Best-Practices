import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.feature.musicplayer.widgets.HorizontalPlayListWidget
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun HorizontalPlayListWidgetScreenShot() {
    MyAppTheme {
        HorizontalPlayListWidget(playlistListEntity = songListItem.playlistList.first(), { })
    }
}
