package com.mrtckr.livecoding.data.model.musicplayer

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistEntity(
    val id: String,
    val title: String,
    val iconUrl: String,
    val songList: List<SongListItem>,
)
