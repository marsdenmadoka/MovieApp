package com.madoka.movieshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.madoka.domain.model.Movie


@Composable
fun TopPlayingNowSectionItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onItemClick: () -> Unit
) {

    Box {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imageMovieCover, textMovieTitle, ratingBarRanking) = createRefs()

            //region Movie Cover Image
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.posterPath)
                    .crossfade(true)
                    .build(),
                contentDescription = "Movie Image",
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(imageMovieCover){}
                /**                 .placeholder(
                visible = false,
                color = Color.Gray,
                //highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                ) **/,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,

                )
            //region Movie Title
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .constrainAs(textMovieTitle) {
                        width = Dimension.fillToConstraints
                        start.linkTo(parent.start)
                        bottom.linkTo(imageMovieCover.bottom) //bottom.linkTo(ratingBarRanking.top)
                        end.linkTo(parent.end)
                    },
                text = movie.title ?: "Unknown movie" ,
                fontSize = 32.sp,
                maxLines = 2,
                style = MaterialTheme.typography.h2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                // color = dominantTextColor
            )
        }
    }
}






//
//val painter = rememberImagePainter(
//    data = movie.posterPath,
//    builder = {
//        crossfade(true)
//    }
//)
//
//
//
//Image(
//modifier = Modifier
//.fillMaxSize()
//.constrainAs(imageMovieCover) {}
///**                 .placeholder(
//visible = false,
//color = Color.Gray,
////highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
//) **/
//,
//alignment = Alignment.Center,
//contentScale = ContentScale.Crop,
//painter = painter,//painterResource(id = faketopitem.Image),
//contentDescription = null
//)
