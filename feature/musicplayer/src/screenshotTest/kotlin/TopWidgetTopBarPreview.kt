import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.common.ui.Constants.CATEGORIES
import com.mrtckr.livecoding.feature.musicplayer.UserDataUiState
import com.mrtckr.livecoding.feature.musicplayer.UserDataUiStateProvider
import com.mrtckr.livecoding.feature.musicplayer.widgets.TopWidgetTopBar
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun TopWidgetTopBarPreview(@PreviewParameter(UserDataUiStateProvider::class) state: UserDataUiState) {
    MyAppTheme {
        TopWidgetTopBar(
            userData = state, selectedCategory = CATEGORIES.first()
        ) { }
    }
}

@PreviewTest
@Preview
@Composable
fun TopWidgetTopBarPreviewMusicSelected(@PreviewParameter(UserDataUiStateProvider::class) state: UserDataUiState) {
    MyAppTheme {
        TopWidgetTopBar(
            userData = state, selectedCategory = CATEGORIES[1]
        ) { }
    }
}

@PreviewTest
@Preview
@Composable
fun TopWidgetTopBarPreviewPodcastSelected(@PreviewParameter(UserDataUiStateProvider::class) state: UserDataUiState) {
    MyAppTheme {
        TopWidgetTopBar(
            userData = state, selectedCategory = CATEGORIES[2]
        ) { }
    }
}
