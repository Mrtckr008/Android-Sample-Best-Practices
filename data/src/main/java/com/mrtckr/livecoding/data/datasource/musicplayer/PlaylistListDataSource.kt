package com.mrtckr.livecoding.data.datasource.musicplayer

import androidx.datastore.core.DataStore
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException
import javax.inject.Inject

class PlaylistListDataSource @Inject constructor(private val dataStore: DataStore<PlaylistListEntity>) :
    PlaylistListRepository {

    override val songData: Flow<PlaylistListEntity>
        get() = dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(PlaylistListEntity())
            } else {
                throw Exception("the reason might to be related datastore - > " + exception.message)
            }
        }

    override suspend fun updateSongListData(playlistListEntity: PlaylistListEntity) {
        dataStore.updateData {
            it.copy(
                playlistList = playlistListEntity.playlistList,
            )
        }
    }
}
