package com.mrtckr.livecoding.data.testing

import com.mrtckr.livecoding.data.model.musicplayer.PlayListDataEntity
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistEntity
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import java.util.Random

val songListItem = PlaylistListEntity(
    playlistList = listOf(
        PlayListDataEntity(
            title = "Liked List", type = "GridLikedList", playlistList = listOf(
                PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                    title = "Liked List",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/FVvpczq/Muddy-Waters.png",
                    title = "Muddy Waters Radio",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/vBdMCqK/Fats-Domino.png",
                    title = "Fats Domino Radio",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/1dN21Pg/Pink-Floyd.png",
                    title = "Pink Floyd Best 10",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/DbdrN3Q/French-Coffee-House.png",
                    title = "French Coffee House",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/6FBWCpS/Best-Of50s.png",
                    title = "Best of 50s",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/10VZQgh/Blues-Rock.png",
                    title = "Blues & Rock",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/5LbBWkH/Freddy-King.png",
                    title = "Freddy King",
                    songList = listOf()
                )
            )
        ), PlayListDataEntity(
            title = "Continue to Watch", type = "HorizontalPlaylist", playlistList = listOf(
                PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                    title = "Eric Clapton, Albert Collins, The Rolling Stone",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/FVvpczq/Muddy-Waters.png",
                    title = "Eric Clapton, Stevie Ray Vaughan, Freddie King, Muddy Waters",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/vBdMCqK/Fats-Domino.png",
                    title = "Stevie Ray Vaughan, Aretha Franklin, Nina Simone, Elmore James",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/1dN21Pg/Pink-Floyd.png",
                    title = "Sam Magnett, John Mayall, B.B. King, Muddy Waters, T-Bone Walker",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/DbdrN3Q/French-Coffee-House.png",
                    title = "Buddy Guy, Little Walter, Bo Diddley, Elmore James",
                    songList = listOf()
                )
            )
        ), PlayListDataEntity(
            title = "Based On Your Listens to", type = "HorizontalPlaylist", playlistList = listOf(
                PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                    title = "Fats Domino, The Spaniels, Tommy Edwards and more",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/FVvpczq/Muddy-Waters.png",
                    title = "Freddy King, Frank Sinatra, Elvis Presley, Ben E. King, Elton John",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/vBdMCqK/Fats-Domino.png",
                    title = "Book Reading Playlist. Pride and prejudice, Milk and honey, twilight, new moon",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/1dN21Pg/Pink-Floyd.png",
                    title = "Athena",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/DbdrN3Q/French-Coffee-House.png",
                    title = "Fats Domino",
                    songList = listOf()
                ), PlaylistEntity(
                    id = Random().toString(),
                    iconUrl = "https://i.ibb.co/6FBWCpS/Best-Of50s.png",
                    title = "European Coffee House. Relax, study, lie down in peace",
                    songList = listOf()
                )
            )
        )
    )
)
