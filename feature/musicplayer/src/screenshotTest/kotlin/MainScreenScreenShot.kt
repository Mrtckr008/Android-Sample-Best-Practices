import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.musicplayer.widgets.listdetail.TopToolbar
import theme.MyAppTheme
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding.feature.musicplayer.SongListDataUiState
import com.mrtckr.livecoding.feature.musicplayer.widgets.MusicPlayer

@PreviewTest
@Preview(backgroundColor = 0xFF3F51B5)
@Composable
fun MainScreenScreenShot() {
    MyAppTheme {
        MusicPlayer(
            SongListDataUiState.Success(playlistListEntity = songListItem), { }
        )
    }
}
