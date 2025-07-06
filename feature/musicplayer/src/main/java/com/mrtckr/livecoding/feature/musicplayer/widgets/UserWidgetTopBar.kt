package com.mrtckr.livecoding.feature.musicplayer.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrtckr.common.ui.Constants.CATEGORIES
import com.mrtckr.common.ui.theme.MyAppTheme
import com.mrtckr.common.ui.widgets.DynamicAsyncImage
import com.mrtckr.common.ui.widgets.LoadingScreen
import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding.feature.musicplayer.UserDataUiState
import com.mrtckr.livecoding.feature.musicplayer.extension.OvalTextSurface
import kotlin.random.Random

@Composable
fun TopWidgetTopBar(
    userData: UserDataUiState, selectedCategory: String, onCategoryChange: (String) -> Unit
) {
    when (userData) {
        is UserDataUiState.Success -> {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .selectableGroup(), verticalAlignment = Alignment.CenterVertically
            ) {
                DynamicAsyncImage(
                    imageUrl = userData.userData.iconUrl,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    isCircular = true
                )
                Spacer(Modifier.width(12.dp))

                CATEGORIES.forEach { category ->
                    OvalTextSurface(
                        text = category,
                        isSelected = (selectedCategory == category),
                        onClick = { onCategoryChange(category) })
                    Spacer(Modifier.width(8.dp))
                }
            }
        }

        else -> {
            LoadingScreen()
        }
    }
}

@Preview
@Composable
fun TopWidgetTopBarPreview() {
    MyAppTheme {
        TopWidgetTopBar(
            userData = UserDataUiState.Success(
                User(
                    id = Random.toString(),
                    iconUrl = "https://i.ibb.co/vkynLfY/Whats-App-Image-2023-08-02-at-01-00-56.jpg",
                    favoriteList = listOf(),
                    name = "Murat Cakir"
                )
            ), selectedCategory = CATEGORIES.first()
        ) {

        }
    }
}
