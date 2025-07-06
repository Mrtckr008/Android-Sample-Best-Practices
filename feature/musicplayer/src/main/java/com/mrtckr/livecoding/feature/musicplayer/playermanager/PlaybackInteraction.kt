package com.mrtckr.livecoding.feature.musicplayer.playermanager

interface PlaybackInteraction {
    fun seekTo(position: Long)
    fun updatePlaybackState()
}
