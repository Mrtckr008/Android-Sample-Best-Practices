package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets

import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding2.ui.compose.common.Constants.CATEGORIES
import com.mrtckr.livecoding2.ui.compose.musicplayer.UserDataUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TopWidgetTopBarTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun topWidgetTopBar_displaysLoadingScreen_whenUserDataIsLoading() {
        composeTestRule.setContent {
            TopWidgetTopBar(
                userData = UserDataUiState.Loading, selectedCategory = CATEGORIES.first()
            ) {}
        }

        composeTestRule.onNodeWithTag("LoadingBox").assertIsDisplayed()
    }

    @Test
    fun topWidgetTopBar_displaysUserIconAndCategories_whenUserDataIsSuccess() {
        val testUserData = UserDataUiState.Success(
            User(
                id = "1",
                iconUrl = "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg",
                name = "Murat Cakir",
                favoriteList = listOf()
            )
        )
        composeTestRule.setContent {
            TopWidgetTopBar(
                userData = testUserData, selectedCategory = CATEGORIES.first()
            ) {}
        }

        composeTestRule.onNodeWithTag("UserIcon").assertIsDisplayed()

        CATEGORIES.forEach { category ->
            composeTestRule.onNodeWithText(category).assertIsDisplayed()
        }
    }

    @Test
    fun topWidgetTopBar_clickingCategory_changesSelection() {
        val userData = UserDataUiState.Success(
            User(
                id = "1",
                iconUrl = "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg",
                name = "Murat Cakir",
                favoriteList = listOf()
            )
        )

        composeTestRule.setContent {
            var selected by remember { mutableStateOf(CATEGORIES.first()) }

            TopWidgetTopBar(
                userData = userData, selectedCategory = selected, onCategoryChange = { clicked ->
                    selected = clicked
                })
        }

        val firstTag = "tag_${CATEGORIES.first()}"
        val targetTag = "tag_${CATEGORIES.last()}"

        composeTestRule.onNodeWithTag(firstTag).assertIsSelected()
        composeTestRule.onNodeWithTag(targetTag).performClick()

        composeTestRule.onNodeWithTag(targetTag).assertIsSelected()
        composeTestRule.onNodeWithTag(firstTag).assertIsNotSelected()
    }

    @Test
    fun topWidgetTopBar_clickingCategory_invokesCallback() {
        var clickedCategory: String? = null
        val userData = UserDataUiState.Success(
            User(
                id = "1",
                iconUrl = "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg",
                name = "Murat Cakir",
                favoriteList = listOf()
            )
        )

        composeTestRule.setContent {
            TopWidgetTopBar(
                userData = userData,
                selectedCategory = CATEGORIES.first(),
                onCategoryChange = { clicked ->
                    clickedCategory = clicked
                })
        }

        composeTestRule.onNodeWithTag("tag_${CATEGORIES.last()}").performClick()

        assertThat(clickedCategory).isEqualTo(CATEGORIES.last())
    }
}
