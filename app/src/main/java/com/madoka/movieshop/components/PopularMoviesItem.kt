package com.madoka.movieshop.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import com.madoka.domain.model.Movie
import com.madoka.movieshop.ui.theme.DarkSurface
import com.madoka.movieshop.ui.theme.Golden
import com.madoka.movieshop.utils.getRating


@Composable
fun PopularMovieItem(
    movie: Movie,
    navController: NavController,
    onClickItem: (Movie) -> Unit
) {

    val defaultDominantTextColor = MaterialTheme.colors.onSurface
    val dominantColor = MaterialTheme.colors.surface
    val dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }
    val dominantSubTextColor by remember { mutableStateOf(defaultDominantTextColor) }


    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = movie.posterPath)
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
            }).build()
    )



    Card(
        modifier = Modifier
            .width(300.dp)
            .height(220.dp)
            .clickable {
                onClickItem(movie)

            }
            .placeholder(
                visible = false,
                color = Color.Black,
                highlight = PlaceholderHighlight.fade(highlightColor = Color.White)
            ),
        elevation = 8.dp,
        shape = RoundedCornerShape(4.dp)
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imageMovieCover, boxFadingEdge, textMovieTitle, rowRankRelease) = createRefs()

            //region Movie Cover
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .placeholder(
                        visible = false,
                        color = Color.Black,
                        highlight = PlaceholderHighlight.fade(highlightColor = Color.White)
                    )
                    .background(color = Color.Gray)
                    .constrainAs(imageMovieCover) {},
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                painter = painter,
                contentDescription = null
            )

            //region Fading Edge
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                dominantColor
                            )
                        )
                    )
                    .constrainAs(boxFadingEdge) {
                        bottom.linkTo(parent.bottom)
                    }
            )

            //region Movie Title
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .constrainAs(textMovieTitle) {
                        width = Dimension.fillToConstraints
                        start.linkTo(parent.start)
                        bottom.linkTo(rowRankRelease.top)
                        end.linkTo(parent.end)
                    },
                text = movie.title ?: "Unknown movie",
                fontSize = 18.sp,
                maxLines = 2,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                color = dominantTextColor
            )

            //region Movie Rating
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .constrainAs(rowRankRelease) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    },
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RatingBar(
                    modifier = Modifier,
                    value = movie.voteAverage?.getRating()?.toFloat() ?: 0f,
                    config = RatingBarConfig()
                        .activeColor(Golden)
                        .inactiveColor(DarkSurface)
                        .stepSize(StepSize.HALF)
                        .isIndicator(true)
                        .stepSize(StepSize.HALF)
                        .numStars(5)
                        .isIndicator(true)
                        .size(16.dp)
                        .style(RatingBarStyle.HighLighted),
                    onValueChange = {},
                    onRatingChanged = {}
                )
                if (!movie.releaseDate.isNullOrEmpty()) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .width(1.dp)
                            .height(13.dp),
                        color = dominantSubTextColor,
                    )

                    Text(
                        modifier = Modifier,
                        text = movie.releaseDate,
                        fontSize = 14.sp,
                        maxLines = 1,
                        style = MaterialTheme.typography.h4,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        color = dominantSubTextColor
                    )
                }
            }
            //endregion
        }
    }


}

