package com.mrtckr.livecoding.data.datasource.musicplayer

import androidx.datastore.core.DataStore
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class PlaylistListDataSourceTest {

    private lateinit var dataSource: PlaylistListDataSource
    private val dataStore: DataStore<PlaylistListEntity> = mockk()

    @Before
    fun setUp() {
        dataSource = PlaylistListDataSource(dataStore)
    }

    @Test
    fun `songData should emit default value on IOException`() = runTest {
        val exceptionFlow = flowOf<PlaylistListEntity>().catch { throw IOException() }
        coEvery { dataStore.data } returns exceptionFlow

        var result = PlaylistListEntity()
        dataSource.songData.collect {
            result = it
        }
        assertEquals(PlaylistListEntity(), result)
    }

    @Test
    fun `songData should emit stored value`() = runTest {
        val playlist = PlaylistListEntity(songListItem.playlistList)
        val dataFlow = flowOf(playlist)
        coEvery { dataStore.data } returns dataFlow

        val result = dataSource.songData.first()
        assertEquals(playlist, result)
    }

    @Test
    fun `updateSongListData should update data in DataStore`() = runTest {
        val playlist = PlaylistListEntity(songListItem.playlistList)
        coEvery { dataStore.updateData(any()) } returns playlist

        dataSource.updateSongListData(playlist)

        coVerify { dataStore.updateData(any()) }
    }
}
