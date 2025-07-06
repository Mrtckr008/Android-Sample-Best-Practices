import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.feature.musicplayer.SongListDataUiState
import com.mrtckr.livecoding.feature.musicplayer.widgets.MusicPlayer
import theme.MyAppTheme

@PreviewTest
@Preview(device = "spec:parent=Nexus 10,orientation=portrait")
@Composable
fun MusicPlayerPortraitTabletPreview() {
    MyAppTheme {
        MusicPlayer(
            playListData = SongListDataUiState.Success(songListItem),
            navigateToPlaylistDetailWithId = {

            })
    }
}
