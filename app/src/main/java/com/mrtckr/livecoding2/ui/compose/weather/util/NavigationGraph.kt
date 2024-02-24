package com.mrtckr.livecoding2.ui.compose.weather.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mrtckr.livecoding2.ui.compose.musicplayer.MusicPlayer
import com.mrtckr.livecoding2.ui.compose.weather.widgets.WeatherScreenRoute
import com.mrtckr.livecoding2.ui.compose.weather.notification.NotificationsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { WeatherScreenRoute() }
        composable(Screen.Dashboard.route) { MusicPlayer() }
        composable(Screen.Notifications.route) { NotificationsScreen() }
    }
}
