package com.mrtckr.livecoding.data

import com.mrtckr.common.network.AppDispatchers
import com.mrtckr.common.network.Dispatcher
import com.mrtckr.livecoding.data.datasource.UserService
import com.mrtckr.livecoding.domain.entity.user.FavoriteList
import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val iUserData: UserService,
    @Dispatcher(AppDispatchers.IO) val ioDispatcher: CoroutineDispatcher
) : UserRepository {

    override fun getUserData(): Flow<User> = flow {
        val userData = iUserData.getUserData()
        emit(
            User(id = userData.id,
                iconUrl = userData.iconUrl,
                name = userData.name,
                favoriteList = userData.favoriteEntity.map {
                    FavoriteList(it.id, it.name)
                })
        )
    }.flowOn(ioDispatcher)
}
