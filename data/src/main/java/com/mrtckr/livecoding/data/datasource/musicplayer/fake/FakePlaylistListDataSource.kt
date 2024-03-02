package com.mrtckr.livecoding.data.datasource.musicplayer.fake

import com.mrtckr.livecoding.data.datasource.musicplayer.PlaylistListRepository
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.testing.songListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakePlaylistListDataSource : PlaylistListRepository {

    private val _songData = MutableStateFlow(songListItem)
    override val songData: Flow<PlaylistListEntity>
        get() = _songData

    override suspend fun updateSongListData(playlistListEntity: PlaylistListEntity) {
        _songData.value = playlistListEntity
    }
}
