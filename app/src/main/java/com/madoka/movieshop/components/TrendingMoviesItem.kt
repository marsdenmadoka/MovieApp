package com.madoka.movieshop.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.madoka.domain.model.Movie
import com.madoka.movieshop.screens.home.MovieState
import com.madoka.movieshop.ui.theme.MovieShopTheme


@Composable
fun TrendingMoviesItem(
    movie: Movie,
    onClickItem: (Movie) -> Unit
) {

    Column(
        modifier = Modifier
            .placeholder(
                visible = false,
                color = Color.Gray,
                highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
            ),

        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Card(modifier = Modifier
            .width(150.dp)
            .fillMaxHeight()
            .clickable {  onClickItem(movie)  }
            .placeholder(
                visible = false,
                color = Color.Black,
                highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
            ),
            elevation = 8.dp,
            shape = RoundedCornerShape(4.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.posterPath)
                    .crossfade(true)
                    .build(),
                contentDescription = "Movie Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,

                )
        }

        Text(
            modifier = Modifier
                .width(145.dp),
            text = movie.title ?: "Unknown movie",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSurface,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TrendingnowPreview() {
    MovieShopTheme {
        TrendingMoviesItem( movie =
        Movie(1,"title","posterpath",
            "23.9.2022",
            3.5,5.0,"abcdefghijklmn",3),
            onClickItem = {}
            )
    }
}



