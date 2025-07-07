import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.musicplayer.widgets.listdetail.MusicPlayerBottomWidget
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun MusicPlayerWidgetPreview() {
    MyAppTheme {
        Box {
            MusicPlayerBottomWidget(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 70.dp)
                    .height(60.dp)
                    .align(Alignment.BottomCenter)
                    .background(MaterialTheme.colorScheme.onTertiary)
                    .fillMaxWidth()
                    .height(70.dp),
                imageUrl = "",
                title = "Come on, Let's Go",
                singer = "Ritchie Valens",
                serviceBinder = null,
                onPlayPauseClicked = {})
        }
    }
}