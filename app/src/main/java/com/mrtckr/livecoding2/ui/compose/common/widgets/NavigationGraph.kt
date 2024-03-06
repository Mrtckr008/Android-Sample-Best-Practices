package com.mrtckr.livecoding2.ui.compose.common.widgets

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.MusicPlayerRoute
import com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail.MusicListDetailRoute
import com.mrtckr.livecoding2.ui.compose.notification.NotificationsScreen
import com.mrtckr.livecoding2.ui.compose.weather.widgets.WeatherScreenRoute

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { WeatherScreenRoute() }
        composable(Screen.MusicPlayer.route) {
            MusicPlayerRoute(navigateToPlaylistDetail = { selectedPlaylistId ->
                navController.navigate("playlistDetail/${selectedPlaylistId}")
            })
        }
        composable(Screen.Notifications.route) { NotificationsScreen() }
        composable("playlistDetail/{songListId}") { backStackEntry ->
            val songListId = backStackEntry.arguments?.getString("songListId") ?: ""
            MusicListDetailRoute(songListId = songListId, navController = navController)
        }
    }
}
