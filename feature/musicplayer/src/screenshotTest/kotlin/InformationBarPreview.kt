import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.mrtckr.livecoding.feature.musicplayer.widgets.listdetail.InformationBar
import theme.MyAppTheme

@PreviewTest
@Preview
@Composable
fun InformationBarPreview() {
    MyAppTheme {
        Column {
            InformationBar(
                listTitle = "Eric Clapton top 10",
                userFullName = "Murat Cakir",
                scrollableWidgetBounds = remember { mutableStateOf(1f) })
        }
    }
}