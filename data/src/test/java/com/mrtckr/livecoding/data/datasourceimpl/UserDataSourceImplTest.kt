package com.mrtckr.livecoding.data.datasourceimpl

import app.cash.turbine.test
import com.mrtckr.livecoding.data.UserDataSourceImpl
import com.mrtckr.livecoding.data.datasource.UserService
import com.mrtckr.livecoding.data.model.musicplayer.user.FavoriteEntity
import com.mrtckr.livecoding.data.model.musicplayer.user.UserEntity
import com.mrtckr.livecoding.domain.entity.user.FavoriteList
import com.mrtckr.livecoding.domain.entity.user.User
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class UserDataSourceImplTest {

    private lateinit var userService: UserService
    private lateinit var userDataSourceImpl: UserDataSourceImpl
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        userService = mock()
        userDataSourceImpl = UserDataSourceImpl(userService, testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getUserData should return correct user data`() = runTest {
        val fakeUserEntity = UserEntity(
            id = "mrtckr",
            iconUrl = "https://example.com/icon.png",
            name = "Murat Cakir",
            favoriteEntity = listOf(FavoriteEntity("2", "Favorite"))
        )
        val expectedUser = User(
            id = "mrtckr",
            iconUrl = "https://example.com/icon.png",
            name = "Murat Cakir",
            favoriteList = listOf(FavoriteList("2", "Favorite"))
        )

        `when`(userService.getUserData()).thenReturn(fakeUserEntity)

        userDataSourceImpl.getUserData().test {
            assertEquals(expectedUser, awaitItem())
            awaitComplete()
        }
    }
}
