package com.kay.movieapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kay.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Magenta,
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

@Composable
fun MainContent(
    modifier: Modifier,
    navController: NavController,
    movieList: List<String> = listOf(
        "Dragonball z",
        "Kay the movie",
        "Lion King",
        "Titanic",
        "Life",
        "Kien",
        "De la Riva",
        "Lasso",
        "Single leg x"
    )
) {
    Column(
        modifier = modifier
            .padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) { movieTitle ->
                MovieRow(movieTitle = movieTitle) { movie ->
                    Log.d("TAG", "mainContent: $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}

// We want to create a nice card around each items.
// Make each row clickable
@Composable
fun MovieRow(
    movieTitle: String,
    onItemClicked: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClicked(movieTitle) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        // Movie title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // ICON
            Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "AccountIcon"
                )
            }
            Text(text = movieTitle)
        }
    }
}
