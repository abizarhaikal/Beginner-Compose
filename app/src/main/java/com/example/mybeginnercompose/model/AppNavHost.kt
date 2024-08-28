package com.example.mybeginnercompose.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mybeginnercompose.ui.view.DetailScreen
import com.example.mybeginnercompose.ui.view.MainScreen
import com.example.mybeginnercompose.ui.view.ProfileScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
        modifier = modifier
    ) {
        composable(Routes.Home.route) {
            MainScreen(navController = navController)
        }
        composable("${Routes.Detail.route}/{playerId}") { backStackEntry ->
            val playerId = backStackEntry.arguments?.getString("playerId")?.toIntOrNull()
            playerId?.let {
                DetailScreen(playerId = it, navController = navController)
            }
        }
        composable(Routes.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}