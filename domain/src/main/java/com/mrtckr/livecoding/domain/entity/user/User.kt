package com.mrtckr.livecoding.domain.entity.user

data class User(
    val id: String,
    val iconUrl: String,
    val name: String,
    val favoriteList: List<FavoriteList>
)
