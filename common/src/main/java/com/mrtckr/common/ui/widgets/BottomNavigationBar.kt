package com.mrtckr.common.ui.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrtckr.common.ui.theme.MyAppTheme

@Composable
fun BottomNavigationBar(backStack: SnapshotStateList<Screen>, modifier: Modifier = Modifier) {
    val current = backStack.lastOrNull()
    NavigationBar(containerColor = Color.Black, modifier = modifier) {
        listOf(Screen.Weather, Screen.MusicPlayer, Screen.Notifications).forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(stringResource(screen.resourceId)) },
                selected = current == screen,
                onClick = { backStack.add(screen) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    val backStack = remember { mutableStateListOf<Screen>(Screen.Weather) }
    MyAppTheme {
        BottomNavigationBar(backStack = backStack)
    }
}
