package com.mrtckr.livecoding.data.model.musicplayer

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistListEntity(
    val playlistList: List<PlayListDataEntity> = listOf(),
)
