package com.mrtckr.livecoding.domain.repository

import com.mrtckr.livecoding.domain.entity.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserData(): Flow<User>
}
