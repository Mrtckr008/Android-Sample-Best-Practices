package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import android.content.Context
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistEntity
import com.mrtckr.livecoding.data.testing.songListItem
import com.mrtckr.livecoding2.ui.compose.common.Constants.DEFAULT_VALUE
import com.mrtckr.livecoding2.ui.compose.common.Constants.INVISIBLE_ALPHA
import com.mrtckr.livecoding2.ui.compose.common.Constants.VISIBLE_ALPHA
import com.mrtckr.livecoding2.ui.compose.common.dpToPx
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme
import com.mrtckr.livecoding2.ui.compose.common.widgets.DynamicAsyncImage
import com.mrtckr.livecoding2.ui.compose.common.widgets.ErrorScreen
import com.mrtckr.livecoding2.ui.compose.common.widgets.LoadingScreen
import com.mrtckr.livecoding2.ui.compose.musicplayer.MusicPlayerViewModel
import com.mrtckr.livecoding2.ui.compose.musicplayer.SongListDataUiState
import com.mrtckr.livecoding2.ui.compose.musicplayer.UserDataUiState
import com.mrtckr.livecoding2.ui.compose.musicplayer.service.MusicPlayerService
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicPlayerConst.ANIMATION_DURATION
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicPlayerConst.BACKGROUND_COLOR_AFFECT_MIN_VALUE
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicPlayerConst.IMAGE_SIZE_SCALE_FACTOR_RATIO
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicPlayerConst.LIST_DETAIL_IMAGE_SIZE
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicPlayerConst.THRESHOLD_OF_SCALE_ANIMATION
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.player.PlayerDetailRoute
import kotlinx.coroutines.launch

@Composable
fun MusicListDetailRoute(
    songListId: String,
    navController: NavHostController,
    viewModel: MusicPlayerViewModel = hiltViewModel(),
    serviceBinder: MusicPlayerService.MusicServiceBinder?,
    bottomSheetWidgetBounds: MutableState<Float?>,
) {
    val userUIStateData by viewModel.userData.collectAsStateWithLifecycle()
    val playListUIStateData by viewModel.songListData.collectAsStateWithLifecycle()

    when {
        userUIStateData is UserDataUiState.Loading || playListUIStateData is SongListDataUiState.Loading -> {
            LoadingScreen()
            return
        }

        userUIStateData is UserDataUiState.Success && playListUIStateData is SongListDataUiState.Success -> {
            val userFullName = (userUIStateData as UserDataUiState.Success).userData.name
            val playlistData =
                (playListUIStateData as SongListDataUiState.Success).playlistListEntity.playlistList.firstOrNull { it.playlistList.any { playlist -> playlist.id == songListId } }?.playlistList?.firstOrNull { it.id == songListId }

            if (playlistData != null) {
                MusicPlayerDetailList(
                    playlistData,
                    userFullName,
                    navController,
                    serviceBinder,
                    bottomSheetWidgetBounds
                )
            } else {
                ErrorScreen("Playlist not found")
            }
        }

        else -> {
            ErrorScreen("An error occurred")
        }
    }
}


@Composable
fun MusicPlayerDetailList(
    playlistEntity: PlaylistEntity,
    userFullName: String,
    navController: NavHostController,
    serviceBinder: MusicPlayerService.MusicServiceBinder?,
    bottomSheetWidgetBounds: MutableState<Float?>,
) {
    val context = LocalContext.current

    val scrollableWidgetBounds = remember { mutableStateOf<Float?>(null) }
    val scrollableWidgetTopPoint = scrollableWidgetBounds.value ?: DEFAULT_VALUE

    val (imageSize, imageAlpha) = remember {
        mutableStateOf(LIST_DETAIL_IMAGE_SIZE.dp) to mutableStateOf(
            VISIBLE_ALPHA
        )
    }

    val animatedAlpha by animateFloatAsState(
        targetValue = if (imageAlpha.value == INVISIBLE_ALPHA) VISIBLE_ALPHA else INVISIBLE_ALPHA,
        animationSpec = tween(durationMillis = ANIMATION_DURATION)
    )

    val colorAffectBottom =
        (scrollableWidgetTopPoint * IMAGE_SIZE_SCALE_FACTOR_RATIO).coerceAtLeast(
            BACKGROUND_COLOR_AFFECT_MIN_VALUE
        )

    LaunchedEffect(scrollableWidgetTopPoint) {
        val scaleFactor =
            ((THRESHOLD_OF_SCALE_ANIMATION - scrollableWidgetTopPoint).coerceAtLeast(0f)) / THRESHOLD_OF_SCALE_ANIMATION
        imageSize.value =
            (LIST_DETAIL_IMAGE_SIZE - LIST_DETAIL_IMAGE_SIZE * scaleFactor * IMAGE_SIZE_SCALE_FACTOR_RATIO).dp
        imageAlpha.value = (VISIBLE_ALPHA - scaleFactor).coerceAtLeast(INVISIBLE_ALPHA)
    }

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
    ) {
        DynamicAsyncImage(
            imageUrl = playlistEntity.iconUrl,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 6.dp)
                .size(imageSize.value)
                .align(Alignment.TopCenter)
                .alpha(imageAlpha.value)
                .testTag("MusicListImage")
        )
        SongList(playlistEntity, userFullName, scrollableWidgetBounds)
        TopToolbar(
            navController = navController,
            title = playlistEntity.title,
            animatedAlpha = animatedAlpha
        )
        MusicPlayerDetailBottomSheet(
            serviceBinder = serviceBinder,
            bottomSheetWidgetBounds = bottomSheetWidgetBounds,
            modifier = Modifier.align(Alignment.BottomCenter),
            playlistEntity = playlistEntity
        )
    }
}

@Composable
fun SongList(
    playlistEntity: PlaylistEntity,
    userFullName: String,
    scrollableWidgetBounds: MutableState<Float?>,
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 6.dp, start = 6.dp, end = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(230.dp))
            InformationBar(
                listTitle = playlistEntity.title,
                userFullName = userFullName,
                scrollableWidgetBounds = scrollableWidgetBounds
            )
            ActionButtonsBar(
                listIconUrl = playlistEntity.iconUrl
            ) {
                val intent = Intent(context, MusicPlayerService::class.java)
                context.startService(intent)
            }
        }
        items(playlistEntity.songList) { songEntity ->
            SongListItemWidget(song = songEntity)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MusicPlayerDetailBottomSheet(
    serviceBinder: MusicPlayerService.MusicServiceBinder?,
    bottomSheetWidgetBounds: MutableState<Float?>,
    playlistEntity: PlaylistEntity,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()
    val context: Context = LocalContext.current

    ModalBottomSheetLayout(sheetState = sheetState, sheetContent = {
        PlayerDetailRoute(
            songListId = "",
            serviceBinder = serviceBinder,
            sheetState = sheetState,
            coroutineScope = coroutineScope,
            bottomSheetWidgetBounds = bottomSheetWidgetBounds
        )
    }) {
        MusicPlayerBottomWidget(modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 80.dp, start = 8.dp, end = 8.dp)
            .height(65.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.onTertiary)
            .clickable {
                coroutineScope.launch { sheetState.show() }
            },
            imageUrl = playlistEntity.songList[3].iconUrl,
            title = playlistEntity.songList[3].name,
            singer = playlistEntity.songList[3].singer,
            serviceBinder = serviceBinder,
            onPlayPauseClicked = { action ->
                val intent = Intent(context, MusicPlayerService::class.java).apply {
                    this.action = action
                }
                context.startService(intent)
            })
    }
    BackHandler(enabled = sheetState.isVisible) {
        coroutineScope.launch {
            sheetState.hide()
        }
    }
}

object MusicPlayerConst {
    const val LIST_DETAIL_IMAGE_SIZE = 250f
    const val IMAGE_SIZE_SCALE_FACTOR_RATIO = 2
    const val THRESHOLD_OF_SCALE_ANIMATION = 270f
    const val BACKGROUND_COLOR_AFFECT_MIN_VALUE = 140f
    const val ANIMATION_DURATION = 1000
}

@Preview
@Composable
fun MusicListDetailPreview() {
    MyAppTheme {
        Surface {
            MusicPlayerDetailList(
                playlistEntity = songListItem.playlistList[1].playlistList[1],
                userFullName = "MM",
                navController = rememberNavController(),
                serviceBinder = null,
                bottomSheetWidgetBounds = remember { mutableStateOf(1f) },
            )
        }
    }
}
