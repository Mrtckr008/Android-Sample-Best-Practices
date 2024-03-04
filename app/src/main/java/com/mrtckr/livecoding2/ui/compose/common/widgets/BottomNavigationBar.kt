package com.mrtckr.livecoding2.ui.compose.common.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mrtckr.livecoding2.ui.compose.common.theme.MyAppTheme

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Home, Screen.MusicPlayer, Screen.Notifications
    )
    NavigationBar(
        containerColor = Color.Black
    ) {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            NavigationBarItem(icon = {
                Icon(
                    screen.icon, contentDescription = null
                )
            },
                label = { Text(stringResource(screen.resourceId)) },
                selected = currentRoute == screen.route,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.Gray
                ),
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                })
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    MyAppTheme {
        BottomNavigationBar(navController = rememberNavController())
    }
}
