package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets.listdetail

import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.data.testing.songListItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MusicListDetailTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun musicListDetailScreen_DisplayedCorrectly() {
        val playlistData = songListItem.playlistList[0].playlistList[0]
        val userFullName = "Murat Cakir"
        composeTestRule.setContent {
            val sheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
            )
            val coroutineScope = rememberCoroutineScope()
            MusicPlayerDetailList(
                playlistEntity = playlistData,
                userFullName = userFullName,
                serviceBinder = null,
                sheetState = sheetState,
                coroutineScope = coroutineScope
            )
        }

        composeTestRule.onAllNodesWithText(playlistData.title).onFirst().assertExists()
        composeTestRule.onAllNodesWithText(playlistData.songList[1].name).onFirst().assertIsDisplayed()
        composeTestRule.onAllNodesWithText(playlistData.songList[1].singer).onFirst().assertIsDisplayed()
        composeTestRule.onNodeWithText("Created by AI for $userFullName").assertExists()
        composeTestRule.onNodeWithTag("BackButton").isDisplayed()
    }

    @Test
    fun musicListDetailScreenScrolledDown_ToolbarDisplayedCorrectly() {
        val playlistData = songListItem.playlistList[0].playlistList[0]
        val userFullName = "Murat Cakir"
        composeTestRule.setContent {
            val sheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
            )
            val coroutineScope = rememberCoroutineScope()
            MusicPlayerDetailList(
                playlistEntity = playlistData,
                userFullName = userFullName,
                serviceBinder = null,
                sheetState,
                coroutineScope
            )
        }

        composeTestRule.onAllNodesWithTag("ListSongName").onLast().performScrollTo()
        composeTestRule.onAllNodesWithTag("ToolbarText").onFirst().isDisplayed()
    }

    @Test
    fun musicListDetailScreen_ImageDisplayedCorrectly() {
        val playlistData = songListItem.playlistList[0].playlistList[0]
        val userFullName = "Murat Cakir"
        composeTestRule.setContent {
            val sheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
            )
            val coroutineScope = rememberCoroutineScope()
            MusicPlayerDetailList(
                playlistEntity = playlistData,
                userFullName = userFullName,
                serviceBinder = null,
                sheetState,
                coroutineScope
            )
        }
        composeTestRule.onAllNodesWithTag("MusicListImage").onFirst().isDisplayed()
    }
}
