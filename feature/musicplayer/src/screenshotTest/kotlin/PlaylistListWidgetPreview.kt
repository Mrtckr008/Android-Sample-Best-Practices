import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.feature.musicplayer.widgets.PlaylistListWidget
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun PlaylistListWidgetPreview() {
    MyAppTheme {
        Surface {
            PlaylistListWidget(songListItem.playlistList[0]) {}
        }
    }
}
