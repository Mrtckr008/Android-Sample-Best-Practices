@file:OptIn(kotlinx.serialization.InternalSerializationApi::class)
package com.mrtckr.livecoding.data.model.musicplayer.user

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteEntity(
    val id: String,
    val name: String,
)
