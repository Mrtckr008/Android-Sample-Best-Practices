@file:OptIn(kotlinx.serialization.InternalSerializationApi::class)
package com.mrtckr.livecoding.data.model.musicplayer

import kotlinx.serialization.Serializable

@Serializable
data class PlayListDataEntity(
    val title: String,
    val type: String,
    val playlistList: List<PlaylistEntity> = listOf(),
)
