package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding.domain.repository.UserRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetUserDataUseCaseTest {

    @Mock
    private lateinit var userRepository: UserRepository

    private lateinit var getUserDataUseCase: GetUserDataUseCase

    @Before
    fun setup() {
        getUserDataUseCase = GetUserDataUseCase(userRepository)
    }

    @Test
    fun `invoke should emit user data when repository succeeds`() = runTest {
        val expectedUser = User(
            id = "1",
            iconUrl = "https://example.com/icon.png",
            name = "John Doe",
            favoriteList = emptyList()
        )

        `when`(userRepository.getUserData()).thenReturn(flowOf(expectedUser))
        val result = getUserDataUseCase().first()
        assertEquals(expectedUser, result)
    }

    @Test
    fun `invoke should emit error when repository fails`() = runTest {
        `when`(userRepository.getUserData()).thenAnswer {
            callbackFlow<User> {
                throw Exception("Data fetch error")
            }
        }

        val resultFlow = getUserDataUseCase()

        resultFlow.catch { e ->
            assertTrue(e is Exception && e.message == "Data fetch error")
        }.collect()
    }
}
