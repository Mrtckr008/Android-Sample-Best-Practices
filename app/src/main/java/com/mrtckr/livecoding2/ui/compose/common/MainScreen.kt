package com.mrtckr.livecoding2.ui.compose.common

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(bottomBar = { BottomNavigationBar(navController) }) {
        NavigationGraph(navController = navController)
    }
}
