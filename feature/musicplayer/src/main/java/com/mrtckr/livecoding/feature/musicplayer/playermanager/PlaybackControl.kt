package com.mrtckr.livecoding.feature.musicplayer.playermanager

interface PlaybackControl {
    fun startPlayback()
    fun pausePlayback()
    fun stopPlayback()
    fun releasePlayback()
}
