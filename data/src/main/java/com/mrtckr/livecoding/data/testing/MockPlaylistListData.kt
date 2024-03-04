package com.mrtckr.livecoding.data.testing

import com.mrtckr.livecoding.data.model.musicplayer.PlayListDataEntity
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistEntity
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import com.mrtckr.livecoding.data.model.musicplayer.SongListItem
import kotlin.random.Random

val songListItem = PlaylistListEntity(
    playlistList = listOf(
        PlayListDataEntity(
            title = "Liked List", type = "GridLikedList", playlistList = listOf(
                PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                    title = "Liked List",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/FVvpczq/Muddy-Waters.png",
                    title = "Muddy Waters Radio",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/vBdMCqK/Fats-Domino.png",
                    title = "Fats Domino Radio",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/1dN21Pg/Pink-Floyd.png",
                    title = "Pink Floyd Best 10",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/DbdrN3Q/French-Coffee-House.png",
                    title = "French Coffee House",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/6FBWCpS/Best-Of50s.png",
                    title = "Best of 50s",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/10VZQgh/Blues-Rock.png",
                    title = "Blues & Rock",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/5LbBWkH/Freddy-King.png",
                    title = "Freddy King",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                )
            )
        ), PlayListDataEntity(
            title = "Continue to Watch", type = "HorizontalPlaylist", playlistList = listOf(
                PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                    title = "Eric Clapton, Albert Collins, The Rolling Stone",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ),
                        SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ),
                        SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ),
                        SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ),
                        SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ),
                        SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ),
                        SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ),
                        SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ),
                        SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ),
                        SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ),
                        SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ),
                        SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        ),
                    ),
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/FVvpczq/Muddy-Waters.png",
                    title = "Eric Clapton, Stevie Ray Vaughan, Freddie King, Muddy Waters",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/vBdMCqK/Fats-Domino.png",
                    title = "Stevie Ray Vaughan, Aretha Franklin, Nina Simone, Elmore James",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/1dN21Pg/Pink-Floyd.png",
                    title = "Sam Magnett, John Mayall, B.B. King, Muddy Waters, T-Bone Walker",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/DbdrN3Q/French-Coffee-House.png",
                    title = "Buddy Guy, Little Walter, Bo Diddley, Elmore James",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                )
            )
        ), PlayListDataEntity(
            title = "Based On Your Listens to", type = "HorizontalPlaylist", playlistList = listOf(
                PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                    title = "Fats Domino, The Spaniels, Tommy Edwards and more",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/FVvpczq/Muddy-Waters.png",
                    title = "Freddy King, Frank Sinatra, Elvis Presley, Ben E. King, Elton John",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/vBdMCqK/Fats-Domino.png",
                    title = "Book Reading Playlist. Pride and prejudice, Milk and honey, twilight, new moon",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ),
                        SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ),
                        SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ),
                        SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ),
                        SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ),
                        SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ),
                        SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ),
                        SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ),
                        SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ),
                        SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ),
                        SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ),
                        SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        ),
                    ),
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/1dN21Pg/Pink-Floyd.png",
                    title = "Athena",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    ),
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/DbdrN3Q/French-Coffee-House.png",
                    title = "Fats Domino",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                ), PlaylistEntity(
                    id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                    iconUrl = "https://i.ibb.co/6FBWCpS/Best-Of50s.png",
                    title = "European Coffee House. Relax, study, lie down in peace",
                    songList = listOf(
                        SongListItem(
                            name = "The Thrill is Gone",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "B.B. King"
                        ), SongListItem(
                            name = "Sweet Home Chicago",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Crossroad Blues",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Robert Johnson"
                        ), SongListItem(
                            name = "Hoochie Coochie Man",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Muddy Waters"
                        ), SongListItem(
                            name = "I'd Rather Go Blind",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Etta James"
                        ), SongListItem(
                            name = "Boom Boom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "John Lee Hooker"
                        ), SongListItem(
                            name = "Pride and Joy",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Stevie Ray Vaughan"
                        ), SongListItem(
                            name = "Stormy Monday",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "T-Bone Walker"
                        ), SongListItem(
                            name = "I'm Tore Down",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Freddie King"
                        ), SongListItem(
                            name = "Born Under a Bad Sign",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Albert King"
                        ), SongListItem(
                            name = "Red House",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Jimi Hendrix"
                        ), SongListItem(
                            name = "Dust My Broom",
                            iconUrl = "https://i.ibb.co/gRhdcsp/Liked-List.png",
                            id = Random.nextInt(0, Int.MAX_VALUE).toString(),
                            singer = "Elmore James"
                        )
                    )
                )
            )
        )
    )
)
