package com.mrtckr.livecoding.data.datasource

import com.mrtckr.livecoding.data.model.musicplayer.user.UserEntity

interface UserService {
    suspend fun getUserData(): UserEntity
}