package com.mrtckr.livecoding.data.datasource.musicplayer

import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import kotlinx.coroutines.flow.Flow

interface PlaylistListRepository {

    val songData: Flow<PlaylistListEntity>

    suspend fun updateSongListData(playlistListEntity: PlaylistListEntity)
}
