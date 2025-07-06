import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding2.ui.compose.notification.NotificationsScreen
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun NotificationsScreenPreview() {
    MyAppTheme {
        NotificationsScreen()
    }
}