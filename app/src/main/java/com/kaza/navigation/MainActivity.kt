package com.kaza.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kaza.navigation.ui.screens.FunFactsNavigationGraph
import com.kaza.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            NavigationTheme {
                FunFactsApp()
            }
        }
    }

    @Composable
    fun FunFactsApp(){
        FunFactsNavigationGraph()
    }
}

