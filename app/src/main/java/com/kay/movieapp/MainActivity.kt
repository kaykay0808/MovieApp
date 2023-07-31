package com.kay.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kay.movieapp.navigation.MovieNavigation
import com.kay.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

// this function just activate a lambda function
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(
    content: @Composable () -> Unit
) {
    MovieAppTheme {
        content()
    }
}

// TODO: Need to learn how to make surface size match parent (fillMaxSize?)
// Need to wrap it around a row, column or box
// TODO: Need to learn how to center the text in the middle of the screen

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MovieNavigation()
    }
}
