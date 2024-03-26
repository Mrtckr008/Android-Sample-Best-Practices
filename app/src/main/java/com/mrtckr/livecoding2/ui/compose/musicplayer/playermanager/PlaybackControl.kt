package com.mrtckr.livecoding2.ui.compose.musicplayer.playermanager

interface PlaybackControl {
    fun startPlayback()
    fun pausePlayback()
    fun stopPlayback()
    fun releasePlayback()
}
