package com.madoka.movieshop.ui.screens.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.madoka.domain.model.Movie
import com.madoka.movieshop.R
import com.madoka.movieshop.ui.components.MovieRatingSection
import com.madoka.movieshop.ui.screens.home.HomeViewModel
import com.madoka.movieshop.ui.screens.home.MovieState
import com.madoka.movieshop.ui.utils.PaletteGenerator
import com.madoka.movieshop.ui.utils.getMovieDuration
import com.madoka.movieshop.ui.utils.getPopularity
import com.madoka.movieshop.ui.utils.getRating


@Composable
fun detailsScreen(
    navController: NavController,
    movieId: Int,
    detailsviewModel: detailsViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 =  detailsviewModel) {
        detailsviewModel.getMovieDetail(movieId)
    }

 val moviedetailsState = detailsviewModel.movieDetailState.collectAsState().value


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
                    modifier = Modifier ,
                    navController =navController ,
                    moviedetailstate = moviedetailsState
                )

                //region Movie Ratings
                val voteAverage = moviedetailsState.movie?.voteAverage
                MovieRatingSection(
                    popularity = voteAverage?.getPopularity(),
                   voteAverage = voteAverage?.getRating()
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
                    text = moviedetailsState.movie?.overview ?:"No Overview",
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
    moviedetailstate:MovieDetailState
) {
    var defaultDominantTextColor = MaterialTheme.colors.onSurface
    var dominantColor = MaterialTheme.colors.surface
    var dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }
    var dominantSubTextColor by remember { mutableStateOf(defaultDominantTextColor) }


    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = moviedetailstate.movie?.posterPath)
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
            }).build()
    )


    if (painter.state is AsyncImagePainter.State.Success) {
        LaunchedEffect(key1 = painter) {
            val imageDrawable = painter.imageLoader.execute(painter.request).drawable
            imageDrawable?.let {
                PaletteGenerator.generateImagePalette(imageDrawable = it) { color ->
                    dominantColor = Color(color.rgb)
                    dominantTextColor = Color(color.titleTextColor)
                }
            }
        }
    }

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

        val (imageMovie, boxFadingEdge, textViewRunTime, textViewTitle, backIcon) = createRefs()

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
            tint = dominantColor, //Color.White,
            modifier = Modifier
                .size(36.dp)
                // .offset(16.dp, 16.dp)
                .constrainAs(backIcon) {
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


        //region Movie Duration
        Text(
            text = moviedetailstate.movie?.runtime.getMovieDuration()?:"",   //"1 hour 30 min",
            color = dominantTextColor,
            style = MaterialTheme.typography.h5,
            fontSize = 15.sp,
            modifier = Modifier.constrainAs(textViewRunTime) {
                start.linkTo(textViewTitle.start)
                bottom.linkTo(textViewTitle.top)
            }
        )


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
            text = moviedetailstate.movie?.title ?: "/Unknown Movie",
            style = MaterialTheme.typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = dominantTextColor,
            fontSize = 30.sp
        )
        //endregion
    }

}






