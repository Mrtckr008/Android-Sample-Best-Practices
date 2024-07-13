package com.mrtckr.livecoding2.ui.compose.common.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mrtckr.livecoding2.ui.compose.musicplayer.service.MusicPlayerService
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.MusicPlayerRoute
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicListDetailRoute
import com.mrtckr.livecoding2.ui.compose.notification.NotificationsScreen
import com.mrtckr.livecoding2.ui.compose.weather.widgets.WeatherScreenRoute

fun NavBackStackEntry.getArgument(key: String): String {
    return arguments?.getString(key) ?: throw IllegalArgumentException("Argument $key is missing")
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    serviceBinder: MusicPlayerService.MusicServiceBinder?,
    bottomSheetWidgetBounds: MutableState<Float?>
) {
    NavHost(navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) { WeatherScreenRoute() }
        composable(Routes.MUSIC_PLAYER) {
            MusicPlayerRoute(navigateToPlaylistDetail = { selectedPlaylistId ->
                navController.navigate("playlistDetail/${selectedPlaylistId}")
            })
        }
        composable(Routes.NOTIFICATIONS) { NotificationsScreen() }
        composable(Routes.PLAYLIST_DETAIL) { backStackEntry ->
            val songListId = backStackEntry.getArgument("songListId")
            MusicListDetailRoute(
                songListId = songListId,
                navController = navController,
                serviceBinder = serviceBinder,
                bottomSheetWidgetBounds = bottomSheetWidgetBounds,
            )
        }
    }
}

object Routes {
    const val HOME = "weather"
    const val MUSIC_PLAYER = "musicPlayer"
    const val NOTIFICATIONS = "notifications"
    const val PLAYLIST_DETAIL = "playlistDetail/{songListId}"
}
