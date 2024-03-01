package com.mrtckr.livecoding.data.model.musicplayer

import kotlinx.serialization.Serializable

@Serializable
data class SongEntity(
    val id: String,
    val imageUrl: String,
    val name: String,
    val description: String,
)
