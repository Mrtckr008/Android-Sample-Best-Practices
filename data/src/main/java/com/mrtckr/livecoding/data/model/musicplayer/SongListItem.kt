@file:OptIn(kotlinx.serialization.InternalSerializationApi::class)
package com.mrtckr.livecoding.data.model.musicplayer

import kotlinx.serialization.Serializable

@Serializable
data class SongListItem(
    val id: String,
    val iconUrl: String,
    val name: String,
    val singer: String,
)
