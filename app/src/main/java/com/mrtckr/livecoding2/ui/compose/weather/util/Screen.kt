package com.mrtckr.livecoding2.ui.compose.weather.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.mrtckr.livecoding2.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    data object Home : Screen("home", R.string.title_weather, Icons.Filled.Home)
    data object Dashboard : Screen("dashboard", R.string.title_dashboard, Icons.Filled.Dashboard)
    data object Notifications :
        Screen("notifications", R.string.title_notifications, Icons.Filled.Notifications)
}
