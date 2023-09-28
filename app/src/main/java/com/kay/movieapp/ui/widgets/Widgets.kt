package com.kay.movieapp.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.kay.movieapp.data.model.MovieData
import com.kay.movieapp.data.model.getMovies

// create a nice card around each items.
// Make each row clickable
@Composable
fun MovieRow(
    movieInfo: MovieData,
    onItemClicked: (String) -> Unit = {}
) {
    var infoExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            // .height(130.dp)
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
                // Hidden information when arrow is clicked
                AnimatedVisibility(visible = infoExpanded) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Plot: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                ) {
                                    append(movieInfo.plot)
                                }
                            },
                            modifier = Modifier.padding(6.dp)
                        )
                        Divider(
                            modifier = Modifier.padding(3.dp)
                        )
                        Text(
                            text = "Director: ${movieInfo.director}",
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = "Actors: ${movieInfo.actors}",
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = "Rating: ${movieInfo.rating}",
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
                // extension arrow?
                Icon(
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { infoExpanded = !infoExpanded },
                    tint = Color.DarkGray,
                    imageVector = if (infoExpanded) {
                        Icons.Filled.KeyboardArrowUp
                    } else {
                        Icons.Filled.KeyboardArrowDown
                    },
                    contentDescription = "Down Arrow"
                )
            }
        }
    }
}

@Composable
fun HorizontalScrollableImageView(newMovieList: List<MovieData>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "Movie image"
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
