package com.madoka.movieshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.madoka.movieshop.FakePopularSectionItems


@Composable
fun popularMovieItem(
    popularmovie: FakePopularSectionItems,
   navController:NavController
) {

    val defaultDominantTextColor = MaterialTheme.colors.onSurface
    var dominantColor by remember { mutableStateOf(Color.Transparent) }
    var dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }
    var dominantSubTextColor by remember { mutableStateOf(defaultDominantTextColor) }

    val painter = rememberImagePainter(
        data = popularmovie.Image, //backdropPath?.loadImage(),
        builder = { crossfade(true) }
    )

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(220.dp)
            .clickable {
//                onClickItem()
                navController.navigate("details")}
        /* .placeholder(
             visible = false,
             color = Color.Black,
             highlight = PlaceholderHighlight.fade()
         )*/,
        elevation = 8.dp,
        shape = RoundedCornerShape(4.dp)
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imageMovieCover, boxFadingEdge, textMovieTitle, rowRankRelease) = createRefs()

            //region Movie Cover
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    /*
                .placeholder(
                    visible = false,
                    color = Color.Black,
                    highlight = PlaceholderHighlight.fade()
                )*/
                    .background(color = Color.Gray)
                    .constrainAs(imageMovieCover) {},
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                painter = painter,
                contentDescription = null
            )
            //endregion

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
            //endregion

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
                text = popularmovie.title ?: "Unknown movie",
                fontSize = 18.sp,
                maxLines = 2,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                color = Color.White//dominantTextColor
            )
            //endregion

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
/*
                RatingBar(
                    modifier = Modifier,
                    value = movie.voteAverage?.getRating() ?: 0f,
                    numStars = 5,
                    size = 15.dp,
                    stepSize = StepSize.HALF,
                    isIndicator = true,
                    ratingBarStyle = RatingBarStyle.Normal,
                    activeColor = Golden,
                    inactiveColor = Gray,
                    onValueChange = {},
                    onRatingChanged = {}
                ) */

                if (!popularmovie.releaseDate.isNullOrEmpty()) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .width(1.dp)
                            .height(13.dp),
                        color =  Color.White//dominantSubTextColor,
                    )

                    Text(
                        modifier = Modifier,
                        text = popularmovie.releaseDate,
                        fontSize = 14.sp,
                        maxLines = 1,
                        style = MaterialTheme.typography.h4,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        color = Color.White//dominantSubTextColor
                    )
                }
            }
            //endregion
        }
    }


}