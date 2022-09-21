package com.madoka.movieshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.madoka.movieshop.FakeTrendingSectionItems


@Composable
fun TrendingMoviesItem(
    trendingMovie: FakeTrendingSectionItems,
    onItemClick: (FakeTrendingSectionItems) -> Unit
) {

    Column(
        modifier = Modifier
        /**      .placeholder(
        visible = false,
        color = Color.Gray,
        highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
        ),**/
        ,

        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Card(modifier = Modifier
            .width(150.dp)
            .fillMaxHeight()
            .clickable { }
            /**.placeholder(
            visible = false,
            color = Color.Black,
            highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
            )**/
            ,
            elevation = 8.dp,
            shape = RoundedCornerShape(4.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                painter = rememberImagePainter(data = trendingMovie.Image,
                    builder = { crossfade(true) }
                ),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                contentDescription = "Trending Movies"
            )
        }

        Text(
            modifier = Modifier
                .width(145.dp),
            text = trendingMovie.title ?: "Unknown movie",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSurface,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )
    }
}



