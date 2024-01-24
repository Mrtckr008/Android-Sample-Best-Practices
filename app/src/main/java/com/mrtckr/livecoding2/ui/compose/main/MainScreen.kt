package com.mrtckr.livecoding2.ui.compose.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}