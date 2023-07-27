package com.kay.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kay.movieapp.ui.screens.detail.DetailsScreen
import com.kay.movieapp.ui.screens.home.HomeScreen

/** NavController */

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            // Here we pass where this should lead us to
            HomeScreen(navController = navController)
        }
        composable(
            route = MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(
                navArgument(name = "movie") {
                    type = NavType.StringType
                }
            )
        ) {
            // Here we pass where this should lead us to
            DetailsScreen(
                navController = navController,
                it.arguments?.getString("movie")
            )
        }
    }
}
