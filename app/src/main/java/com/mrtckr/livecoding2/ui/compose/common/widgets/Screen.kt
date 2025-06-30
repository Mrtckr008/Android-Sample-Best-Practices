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
sealed class Screen(@StringRes val resourceId: Int, val icon: ImageVector) : NavKey {
    @Serializable
    object Weather : Screen(R.string.title_weather, Icons.Filled.Cloud)

    @Serializable
    object MusicPlayer : Screen(R.string.title_music_player, Icons.Filled.LibraryMusic)

    @Serializable
    object Notifications : Screen(R.string.title_notifications, Icons.Filled.Notifications)

    @Serializable
    data class PlaylistDetail(val songListId: String) :
        Screen(R.string.title_music_player, Icons.Filled.LibraryMusic)
}
