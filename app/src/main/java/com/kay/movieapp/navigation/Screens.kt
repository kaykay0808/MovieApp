package com.kay.movieapp.navigation

// www.screen.com/type_of_route
// ( 1 )List out our possible screens.
enum class Screens {
    HomeScreen,
    DetailsScreen;
    // Companion object serves as a container for methods (fromRoute)

    companion object {
        // This function is responsible for creating instances of the Screens enum based on a provided route string
        // The factory function creating a "product"
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
