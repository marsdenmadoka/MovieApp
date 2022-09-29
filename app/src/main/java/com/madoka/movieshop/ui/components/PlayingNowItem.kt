package com.madoka.movieshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import com.madoka.domain.model.Movie
import com.madoka.movieshop.FakeTopSectionItems


@Composable
fun TopPlayingNowSectionItem(
    modifier: Modifier = Modifier,
  //  faketopitem: FakeTopSectionItems,
    movie: Movie,
    onItemClick: () -> Unit
) {
    val painter = rememberImagePainter(
        data = movie.posterPath, //faketopitem.Image,
        builder = {
            crossfade(true)
        }
    )

    Box {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imageMovieCover, textMovieTitle, ratingBarRanking) = createRefs()

            //region Movie Cover Image
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(imageMovieCover) {}
                /**                 .placeholder(
                visible = false,
                color = Color.Gray,
                //highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                ) **/
                ,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                painter = painter,//painterResource(id = faketopitem.Image),
                contentDescription = null
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
                text = movie.title ?: "Unknown movie" ,//faketopitem.title ?: "Unknown movie",
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