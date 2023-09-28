package com.kay.movieapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kay.movieapp.data.model.MovieData
import com.kay.movieapp.data.model.getMovies
import com.kay.movieapp.navigation.Screens
import com.kay.movieapp.ui.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp
            ) {
                Text(
                    text = "Movies"
                )
            }
        }
    ) {
        MainContent(
            modifier = Modifier.padding(it),
            navController = navController
        )
    }
}

// Todo: Make each movie as an object.
@Composable
fun MainContent(
    modifier: Modifier,
    navController: NavController,

    movieList: List<MovieData> = getMovies()
) {
    Column(
        modifier = modifier
            .padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) { movieTitle ->
                MovieRow(
                    movieInfo = movieTitle
                ) { movie ->
                    Log.d("TAG", "mainContent: $movie")
                    navController.navigate(route = Screens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}
