package com.madoka.movieshop.ui.screens.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.madoka.movieshop.R
import com.madoka.movieshop.ui.components.MovieRatingSection


@Composable
fun detailsScreen(navController: NavController,) {

    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp)
                    .verticalScroll(state = scrollState),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {


                //region Movie Poster
                MoviePoster(
                    modifier = Modifier,
                    navController=navController
                    // movieDetails = movieDetails
                )
                //region Movie Ratings
                //val voteAverage = movieDetails?.voteAverage
                MovieRatingSection(
                    // popularity = voteAverage?.getPopularity(),
//                    voteAverage = voteAverage?.getRating()
                )

                //region Movie Overview
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Overview",
                    style = MaterialTheme.typography.h6,
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    /* .placeholder(
                         visible = movieDetails?.overview.isNullOrEmpty(),
                         color = Gray,
                         highlight = PlaceholderHighlight.fade(highlightColor = Color.Gray)
                     ),*/
                    text = stringResource(R.string.movie_overiview), //movieDetails?.overview ?: "",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )

            }
        }


    }
}


@Composable
fun MoviePoster(
    modifier: Modifier,
    navController: NavController,
) {

    val defaultDominantColor = MaterialTheme.colors.surface
    val defaultDominantTextColor = MaterialTheme.colors.onSurface
    var dominantColor by remember { mutableStateOf(defaultDominantColor) }
    var dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }

    val painter = rememberImagePainter(data = R.drawable.drawable1)//movieDetails?.backdropPath?.loadImage())

//    if (painter.state is ImagePainter.State.Success) {
//        LaunchedEffect(key1 = painter) {
//            val imageDrawable = painter.imageLoader.execute(painter.request).drawable
//            imageDrawable?.let {
//                PaletteGenerator.generateImagePalette(imageDrawable = it) { color ->
//                    dominantColor = Color(color.rgb)
//                    dominantTextColor = Color(color.titleTextColor)
//                }
//            }
//        }
// }

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
             /*
            .placeholder(
                visible = movieDetails == null,
                color = Gray,
                highlight = PlaceholderHighlight.shimmer(highlightColor = TextSecondary)
            )*/
    ) {

        val (imageMovie, boxFadingEdge, textViewRunTime, textViewTitle,backIcon) = createRefs()

        //region Movie Poster
        Image(
            painter = painter,
            contentDescription = "movie Poster",
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(imageMovie) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop
        )
        Icon(
            imageVector = Icons.Default.ArrowBack,//from material icons
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(36.dp)
//                .offset(16.dp, 16.dp)
                .constrainAs(backIcon){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .clickable { navController.navigateUp() }

        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
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

        //region Movie Duration
        Text(
            text =  "1 hour 30 min",  //movieDetails?.runtime?.getMovieDuration() ?: "",
            color = dominantTextColor,
            style = MaterialTheme.typography.h5,
            fontSize = 15.sp,
            modifier = Modifier.constrainAs(textViewRunTime) {
                start.linkTo(textViewTitle.start)
                bottom.linkTo(textViewTitle.top)
            }
        )
        //endregion

        //region Movie Title
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(textViewTitle) {
                    width = Dimension.fillToConstraints
                    start.linkTo(parent.start, margin = 6.dp)
                    end.linkTo(parent.end, margin = 6.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
            text = "chuck hulk",//movieDetails?.title ?: stringResource(R.string.unknown_movie),
            style = MaterialTheme.typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = dominantTextColor,
            fontSize = 30.sp
        )
        //endregion
    }

}






