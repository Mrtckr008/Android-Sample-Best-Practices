package com.mrtckr.livecoding2.ui.compose.common.widgets

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.mrtckr.livecoding2.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    data object Home : Screen("Weather", R.string.title_weather, Icons.Filled.Cloud)
    data object MusicPlayer :
        Screen("MusicPlayer", R.string.title_music_player, Icons.Filled.LibraryMusic)

    data object Notifications :
        Screen("notifications", R.string.title_notifications, Icons.Filled.Notifications)
}
