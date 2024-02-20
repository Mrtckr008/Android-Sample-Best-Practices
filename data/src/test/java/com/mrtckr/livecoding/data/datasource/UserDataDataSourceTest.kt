package com.mrtckr.livecoding.data.datasource

import com.mrtckr.livecoding.data.model.musicplayer.user.UserEntity
import com.mrtckr.network.JvmUnitTestFakeAssetManager
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test

class UserDataDataSourceTest {

    private lateinit var userDataSource: UserDataDataSource

    @Before
    fun setup() {
        userDataSource = UserDataDataSource(
            ioDispatcher = Dispatchers.IO,
            networkJson = Json { ignoreUnknownKeys = true },
            assets = JvmUnitTestFakeAssetManager,
        )
    }

    @Test
    fun `when call getData then check json parsed id successfully`() = runTest {
        val userEntityData = UserEntity(
            id = "mrtckr",
            iconUrl = "",
            name = "Murat Cakir",
            favoriteEntity = arrayListOf()
        )
        assertEquals(userEntityData.id, userDataSource.getUserData().id)
    }
}
