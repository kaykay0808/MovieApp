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
        startDestination = Screens.HomeScreen.name
    ) {
        /** HOME SCREEN */
        composable(Screens.HomeScreen.name) {
            // Here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        /** DETAILS SCREEN */
        // www.movie.com/detail-screen/id=32
        composable(
            // The default argument is always a string if we don't pass in /{movie]
            route = Screens.DetailsScreen.name + "/{movie}", // <- Name the value or the variable
            arguments = listOf(
                // Name of nav argument should be the same as the one we passed in the route.
                navArgument(name = "movie") {
                    type = NavType.StringType
                }
            )
            // NavBackStackEntry a variable that contains the information we want
        ) {
            // Here we pass where this should lead us to
            DetailsScreen(
                navController = navController,
                it.arguments?.getString("movie")
            )
        }
    }
}
