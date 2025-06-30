package com.mrtckr.livecoding2.ui.compose.common.widgets

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import com.mrtckr.livecoding2.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) :
    NavKey {
    @Serializable
    object Home3 : Screen("Weather", R.string.title_weather, Icons.Filled.Cloud)

    @Serializable
    object MusicPlayer3 :
        Screen("MusicPlayer", R.string.title_music_player, Icons.Filled.LibraryMusic)

    @Serializable
    object Notifications3 :
        Screen("notifications", R.string.title_notifications, Icons.Filled.Notifications)

    @Serializable
    data class PlaylistDetail3(val songListId: String) :
        Screen("MusicPlayer", R.string.title_music_player, Icons.Filled.LibraryMusic)
}
