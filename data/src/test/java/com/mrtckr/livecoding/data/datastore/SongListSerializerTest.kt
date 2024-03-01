package com.mrtckr.livecoding.data.datastore


import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListItem
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream

class SongListSerializerTest {

    private lateinit var serializer: SongListSerializer

    @Before
    fun setUp() {
        serializer = SongListSerializer()
    }

    @Test
    fun `readFrom should return default value on SerializationException`() = runTest {
        val invalidJson = "invalid json".byteInputStream()
        val result = serializer.readFrom(invalidJson)
        assertEquals(serializer.defaultValue, result)
    }

    @Test
    fun `readFrom should return parsed PlaylistListEntity`() = runTest {
        val playlist = PlaylistListEntity(playlistList = songListItem.playlistList)
        val json = Json.encodeToString(PlaylistListEntity.serializer(), playlist)
        val input = json.byteInputStream()

        val result = serializer.readFrom(input)
        assertEquals(playlist, result)
    }

    @Test
    fun `writeTo should write PlaylistListEntity to OutputStream`() = runTest {
        val playlist = PlaylistListEntity(songListItem.playlistList)
        val output = ByteArrayOutputStream()

        serializer.writeTo(playlist, output)
        val result = Json.decodeFromString(PlaylistListEntity.serializer(), output.toString())

        assertEquals(playlist, result)
    }
}
