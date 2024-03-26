package com.mrtckr.livecoding2.ui.compose.common.widgets

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mrtckr.livecoding2.ui.compose.musicplayer.service.MusicPlayerService
import kotlin.math.max

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(), serviceBinder: MusicPlayerService.MusicServiceBinder?
) {
    val musicPlayerBottomSheetTopPoint = remember { mutableStateOf<Float?>(null) }

    val bottomBarOffset = musicPlayerBottomSheetTopPoint.value?.let { topPoint ->
        max((-topPoint / 1.5f) + 300, 0f)
    } ?: 0f

    Scaffold(bottomBar = {
        BottomNavigationBar(navController, modifier = Modifier.graphicsLayer {
            translationY = bottomBarOffset
        })
    }) {
        NavigationGraph(
            navController = navController,
            serviceBinder = serviceBinder,
            bottomSheetWidgetBounds = musicPlayerBottomSheetTopPoint
        )
    }
}
