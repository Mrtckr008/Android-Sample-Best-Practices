package com.mrtckr.livecoding2.ui.compose.musicplayer.playermanager

interface PlaybackInteraction {
    fun seekTo(position: Long)
    fun updatePlaybackState()
}
