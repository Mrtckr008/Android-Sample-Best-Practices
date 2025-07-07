import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.domain.entity.musicplayer.MediaPlayerState
import com.mrtckr.livecoding.feature.musicplayer.service.MusicPlayerService
import com.mrtckr.livecoding.feature.musicplayer.widgets.player.AnimatedPlayPauseIcon
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun AnimatedPlayPauseIconPreview() {
    val context = LocalContext.current
    MyAppTheme {
        AnimatedPlayPauseIcon(
            playerState = remember { mutableStateOf(MediaPlayerState.STOPPED) },
            onPlayPauseClicked = { action ->
                val intent = Intent(context, MusicPlayerService::class.java).apply {
                    this.action = action
                }
                context.startService(intent)
            })
    }
}
