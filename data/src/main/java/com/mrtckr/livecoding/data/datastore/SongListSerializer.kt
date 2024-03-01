package com.mrtckr.livecoding.data.datastore

import androidx.datastore.core.Serializer
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

@Suppress("BlockingMethodInNonBlockingContext")
class SongListSerializer @Inject constructor() : Serializer<PlaylistListEntity> {

    override val defaultValue: PlaylistListEntity
        get() = PlaylistListEntity()

    override suspend fun readFrom(input: InputStream): PlaylistListEntity {
        return try {
            Json.decodeFromString(
                deserializer = PlaylistListEntity.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: PlaylistListEntity, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = PlaylistListEntity.serializer(), value = t
            ).encodeToByteArray()
        )
    }
}
