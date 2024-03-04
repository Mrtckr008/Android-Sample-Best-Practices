package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.ui.compose.common.Constants.ALPHA_SCALE_RATIO
import com.mrtckr.livecoding2.ui.compose.common.Constants.ANIMATION_DURATION
import com.mrtckr.livecoding2.ui.compose.common.Constants.BACKGROUND_COLOR_AFFECT_MIN_VALUE
import com.mrtckr.livecoding2.ui.compose.common.Constants.DEFAULT_VALUE
import com.mrtckr.livecoding2.ui.compose.common.Constants.IMAGE_SCALE_RATIO
import com.mrtckr.livecoding2.ui.compose.common.Constants.IMAGE_SIZE_SCALE_FACTOR_RATIO
import com.mrtckr.livecoding2.ui.compose.common.Constants.INVISIBLE_ALPHA
import com.mrtckr.livecoding2.ui.compose.common.Constants.LIST_DETAIL_IMAGE_SIZE
import com.mrtckr.livecoding2.ui.compose.common.Constants.SCROLLABLE_WIDGET_TOP_POINT_FOR_THRESHOLD
import com.mrtckr.livecoding2.ui.compose.common.Constants.THRESHOLD_OF_SCALE_ANIMATION
import com.mrtckr.livecoding2.ui.compose.common.Constants.VISIBLE_ALPHA
import com.mrtckr.livecoding2.ui.compose.common.dpToPx
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.DynamicAsyncImage
import com.mrtckr.livecoding2.ui.compose.common.widgets.LoadingScreen
import com.mrtckr.livecoding2.ui.compose.musicplayer.MusicPlayerViewModel
import com.mrtckr.livecoding2.ui.compose.musicplayer.SongListDataUiState
import com.mrtckr.livecoding2.ui.compose.musicplayer.UserDataUiState

@Composable
fun MusicListDetail(
    songListId: String,
    navController: NavHostController,
    viewModel: MusicPlayerViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val userUIStateData by viewModel.userData.collectAsStateWithLifecycle()
    val playListUIStateData by viewModel.songListData.collectAsStateWithLifecycle()

    val scrollableWidgetBounds = remember { mutableStateOf<Float?>(null) }
    val scrollableWidgetTopPoint = scrollableWidgetBounds.value ?: DEFAULT_VALUE

    val imageSize = remember { mutableStateOf(LIST_DETAIL_IMAGE_SIZE.dp) }
    val imageAlpha = remember { mutableFloatStateOf(VISIBLE_ALPHA) }

    val animatedAlpha by animateFloatAsState(
        targetValue = if (imageAlpha.floatValue == INVISIBLE_ALPHA) VISIBLE_ALPHA else INVISIBLE_ALPHA,
        animationSpec = tween(durationMillis = ANIMATION_DURATION),
        label = ""
    )

    LaunchedEffect(scrollableWidgetTopPoint) {
        when {
            scrollableWidgetTopPoint < SCROLLABLE_WIDGET_TOP_POINT_FOR_THRESHOLD -> {
                imageSize.value = DEFAULT_VALUE.dp
                imageAlpha.floatValue = INVISIBLE_ALPHA
            }

            scrollableWidgetTopPoint < THRESHOLD_OF_SCALE_ANIMATION -> {
                val scaleFactor =
                    (THRESHOLD_OF_SCALE_ANIMATION - scrollableWidgetTopPoint) / (THRESHOLD_OF_SCALE_ANIMATION * IMAGE_SCALE_RATIO)
                imageSize.value =
                    LIST_DETAIL_IMAGE_SIZE.dp - (LIST_DETAIL_IMAGE_SIZE.dp * scaleFactor * IMAGE_SIZE_SCALE_FACTOR_RATIO)
                imageAlpha.floatValue = VISIBLE_ALPHA - scaleFactor * ALPHA_SCALE_RATIO
            }

            else -> {
                imageSize.value = LIST_DETAIL_IMAGE_SIZE.dp
                imageAlpha.floatValue = VISIBLE_ALPHA
            }
        }
    }

    if (playListUIStateData is SongListDataUiState.Loading || userUIStateData is UserDataUiState.Loading) {
        LoadingScreen()
        return
    }

    val playlistData =
        (playListUIStateData as SongListDataUiState.Success).playlistListEntity.playlistList.first { playEntity ->
            playEntity.playlistList.any { it.id == songListId }
        }.playlistList.first { it.id == songListId }

    val userData = (userUIStateData as UserDataUiState.Success).userData

    val colorAffectBottom =
        (scrollableWidgetTopPoint * IMAGE_SIZE_SCALE_FACTOR_RATIO).coerceAtLeast(
            BACKGROUND_COLOR_AFFECT_MIN_VALUE
        )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.onSurface,
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.background
                    ), startY = DEFAULT_VALUE, endY = dpToPx(context, colorAffectBottom).toFloat()
                )
            )
            .padding(8.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            DynamicAsyncImage(
                imageUrl = playlistData.iconUrl,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 6.dp)
                    .size(imageSize.value)
                    .align(Alignment.Center)
                    .alpha(imageAlpha.floatValue)
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, bottom = 6.dp, start = 6.dp, end = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(230.dp))
                InformationBar(
                    listTitle = playlistData.title,
                    userFullName = userData.name,
                    context = context,
                    scrollableWidgetBounds = scrollableWidgetBounds
                )
                ActionButtonsBar(listIconUrl = playlistData.iconUrl)
            }
            items(playlistData.songList) { songEntity ->
                SongItem(song = songEntity)
            }
        }
        TopToolbar(
            navController = navController,
            title = playlistData.title,
            imageSize = imageAlpha.floatValue,
            animatedAlpha = animatedAlpha
        )
    }
}

@Preview
@Composable
fun MusicListDetailPreview() {
    MyAppTheme {
        Surface {
            MusicListDetail(
                songListId = songListItem.playlistList.get(1).playlistList[1].id,
                navController = rememberNavController()
            )
        }
    }
}
