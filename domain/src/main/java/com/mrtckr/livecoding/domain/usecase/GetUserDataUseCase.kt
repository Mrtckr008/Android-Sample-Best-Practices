package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetUserDataUseCase @Inject constructor(
    private val userTransaction: UserRepository
) {

    operator fun invoke(): Flow<User> {
        return userTransaction.getUserData()
    }
}
