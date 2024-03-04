package com.mrtckr.livecoding2.ui.compose.musicplayer.widgets

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding2.ui.compose.musicplayer.UserDataUiState
import com.mrtckr.livecoding2.ui.compose.common.Constants.CATEGORIES
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
            TopWidgetTopBar(userData = UserDataUiState.Loading)
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
            TopWidgetTopBar(userData = testUserData)
        }

        composeTestRule.onNodeWithTag("UserIcon").assertIsDisplayed()

        CATEGORIES.forEach { category ->
            composeTestRule.onNodeWithText(category).assertIsDisplayed()
        }
    }

    @Test
    fun topWidgetTopBar_updatesSelectedCategory_whenCategoryIsClicked() {
        val testUserData = UserDataUiState.Success(
            User(
                id = "1",
                iconUrl = "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg",
                name = "Murat Cakir",
                favoriteList = listOf()
            )
        )
        composeTestRule.setContent {
            TopWidgetTopBar(userData = testUserData)
        }

        val newCategory = CATEGORIES.last()
        composeTestRule.onNodeWithText(newCategory).performClick()

        composeTestRule.onNode(hasText(newCategory) and isSelected()).assertExists()
    }
}
