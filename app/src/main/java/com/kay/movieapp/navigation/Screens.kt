package com.kay.movieapp.navigation

// www.screen.com/type_of_route
enum class Screens {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route: String?): Screens =
            // trying to figure out what is the route before the "/"
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}
