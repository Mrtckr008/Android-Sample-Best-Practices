package com.mrtckr.common

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mrtckr.common.ui.widgets.DynamicAsyncImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DynamicAsyncImageTest {
    private val testImageUrl = "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg"

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun dynamicAsyncImage_displaysPlaceholder_whenLoading() {
        composeTestRule.setContent {
            DynamicAsyncImage(
                imageUrl = testImageUrl, contentDescription = "Test Image"
            )
        }

        composeTestRule.onNodeWithContentDescription("Test Image").assertIsDisplayed()
    }

    @Test
    fun dynamicAsyncImage_displaysImage_whenNotLoadingAndNotError() {
        val testImageUrl = testImageUrl
        composeTestRule.setContent {
            DynamicAsyncImage(
                imageUrl = testImageUrl, contentDescription = "Test Image"
            )
        }

        composeTestRule.onNodeWithContentDescription("Test Image").assertIsDisplayed()
    }

    @Test
    fun dynamicAsyncImage_appliesCircularShape_whenIsCircularTrue() {
        composeTestRule.setContent {
            DynamicAsyncImage(
                imageUrl = testImageUrl, contentDescription = "Test Image", isCircular = true
            )
        }

        composeTestRule.onNodeWithContentDescription("Test Image").assertIsDisplayed()
    }
}
