@file:OptIn(kotlinx.serialization.InternalSerializationApi::class)
package com.mrtckr.livecoding.data.model.musicplayer.user

import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    val id: String,
    val iconUrl: String,
    val name: String,
    val favoriteEntity: List<FavoriteEntity>
)
