import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.musicplayer.SongListDataUiState
import com.mrtckr.livecoding.feature.musicplayer.SongListDataUiStateProvider
import com.mrtckr.livecoding.feature.musicplayer.widgets.MusicPlayer
import theme.MyAppTheme

@PreviewTest
@Preview(backgroundColor = 0xFF3F51B5)
@Composable
fun MainScreenScreenShot(@PreviewParameter(SongListDataUiStateProvider::class) state: SongListDataUiState) {
    MyAppTheme {
        MusicPlayer(
            state, { })
    }
}
