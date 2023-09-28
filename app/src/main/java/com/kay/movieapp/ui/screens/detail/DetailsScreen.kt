package com.kay.movieapp.ui.screens.detail

import android.widget.HorizontalScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kay.movieapp.data.model.MovieData
import com.kay.movieapp.data.model.getMovies
import com.kay.movieapp.ui.widgets.HorizontalScrollableImageView
import com.kay.movieapp.ui.widgets.MovieRow

@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String?
) {
    // filter through the movies to find the specific Id
    // getMovies() is our dummy data list.
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier
                            .clickable { navController.popBackStack() },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back"
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "Movies"
                )
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(
                    movieInfo = newMovieList.first()
                )
                /*Text(
                    text = newMovieList[0].title,//movieId.toString(),
                    style = MaterialTheme.typography.h5
                )*/
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Image")
                HorizontalScrollableImageView(newMovieList = newMovieList)
                // HorizontalScrollableImageView(newMovieList)
                Button(
                    onClick = { navController.popBackStack() }
                ) {
                    Text(text = "Go Back")
                }
            }
        }
    }
}
