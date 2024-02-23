package com.mrtckr.livecoding2.ui.compose.weather.util

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(bottomBar = { BottomNavigationBar(navController) }) {
        NavigationGraph(navController = navController)
    }
}
