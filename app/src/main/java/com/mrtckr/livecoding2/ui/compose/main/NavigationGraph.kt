package com.mrtckr.livecoding2.ui.compose.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mrtckr.livecoding2.ui.compose.dashboard.DashboardScreen
import com.mrtckr.livecoding2.ui.compose.home.HomeScreen
import com.mrtckr.livecoding2.ui.compose.notification.NotificationsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Dashboard.route) { DashboardScreen() }
        composable(Screen.Notifications.route) { NotificationsScreen() }
    }
}
