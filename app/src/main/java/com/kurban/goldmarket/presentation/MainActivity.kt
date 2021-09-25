package com.kurban.goldmarket.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurban.goldmarket.common.Screen
import com.kurban.goldmarket.presentation.ui.screen.detail.DetailScreen
import com.kurban.goldmarket.presentation.ui.screen.main.MainScreen
import com.kurban.goldmarket.presentation.ui.screen.splash.SplashScreen
import com.kurban.goldmarket.presentation.ui.theme.GoldMarketTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoldMarketTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(rememberNavController())
                }
            }
        }
    }
}


@Composable
fun NavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.name) {
        composable(route = Screen.SplashScreen.name) {
            SplashScreen {
                navController.popBackStack()
                navController.navigate(route = Screen.MainScreen.name)
            }
        }
        composable(route = Screen.MainScreen.name) {
            MainScreen {
                navController.navigate(route = Screen.DetailScreen.name)
            }
        }
        composable(route = Screen.DetailScreen.name) {
            DetailScreen()
        }
    }
}