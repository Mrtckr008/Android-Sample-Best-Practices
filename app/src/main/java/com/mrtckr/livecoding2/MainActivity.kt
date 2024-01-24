package com.mrtckr.livecoding2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mrtckr.livecoding2.ui.compose.main.MainScreen
import com.mrtckr.livecoding2.ui.compose.main.MyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MainScreen()
            }
        }
    }
}
