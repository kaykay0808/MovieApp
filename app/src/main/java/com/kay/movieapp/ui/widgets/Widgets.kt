package com.kay.movieapp.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.kay.movieapp.data.model.MovieData
import com.kay.movieapp.data.model.getMovies

// create a nice card around each items.
// Make each row clickable
@Composable
fun MovieRow(
    movieInfo: MovieData,
    onItemClicked: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClicked(movieInfo.id) },
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
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movieInfo.images.first())
                        .crossfade(true) // animation when image is loaded
                        .transformations(CircleCropTransformation()) // image is cropped to a circle
                        .build(),
                    contentDescription = "MoviePoster"
                )

                /*Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "AccountIcon"
                )*/
            }
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = movieInfo.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Director: ${movieInfo.title}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Released: ${movieInfo.year}",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieRowPreview() {
    val movieData = getMovies()[9]
    MovieRow(
        movieInfo = movieData
    ) {}
}
