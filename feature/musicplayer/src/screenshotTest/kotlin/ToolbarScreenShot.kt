import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.musicplayer.widgets.listdetail.TopToolbar
import theme.MyAppTheme
import com.mrtckr.livecoding.data.testing.songListItem

@PreviewTest
@Preview(device = "spec:parent=Nexus 10,orientation=portrait", backgroundColor = 0xFF3F51B5)
@Composable
fun ToolbarScreenShot() {
    MyAppTheme {
        TopToolbar(
            songListItem.playlistList.first().title, 1f
        )
    }
}
