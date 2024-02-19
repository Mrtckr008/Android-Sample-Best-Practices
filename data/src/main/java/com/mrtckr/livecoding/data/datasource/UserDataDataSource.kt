package com.mrtckr.livecoding.data.datasource

import com.mrtckr.common.network.AppDispatchers
import com.mrtckr.common.network.Dispatcher
import com.mrtckr.livecoding.data.model.musicplayer.user.UserEntity
import com.mrtckr.network.JvmUnitTestFakeAssetManager
import com.mrtckr.network.fake.FakeAssetManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class UserDataDataSource @Inject constructor(
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : UserService {

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getUserData(): UserEntity = withContext(ioDispatcher) {
        assets.open(USER_DATA).use(networkJson::decodeFromStream)
    }

    companion object {
        private const val USER_DATA = "user_data.json"
    }
}
