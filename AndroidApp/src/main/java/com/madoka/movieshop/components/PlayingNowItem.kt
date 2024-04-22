package com.madoka.movieshop.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import com.madoka.domain.model.Movie
import com.madoka.movieshop.screens.home.MovieState
import com.madoka.movieshop.ui.theme.DarkSurface
import com.madoka.movieshop.ui.theme.Golden
import com.madoka.movieshop.ui.theme.MovieShopTheme
import com.madoka.movieshop.utils.PaletteGenerator
import com.madoka.movieshop.utils.getRating


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun TopPlayingNowSectionItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    moviesState: MovieState,
    onClickItem: (Movie) -> Unit
) {

    val defaultDominantColor = MaterialTheme.colors.surface
    val defaultDominantTextColor = MaterialTheme.colors.onSurface
    var dominantColor by remember { mutableStateOf(defaultDominantColor) }
    var dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }


    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = movie.posterPath)
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


    Box(modifier = Modifier
        .clickable{
            onClickItem(movie)   }) {
        //region Movie Cover Image
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .placeholder(
                    visible = false,//moviesState.isLoading ,
                    color = Color.White,
                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                ),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            painter = painter,
            contentDescription = null
        )


        //region Fading Edge Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            dominantColor
                        )
                    )
                )
        )
        //endregion

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                modifier = Modifier,
                text = movie.title ?: "Unknown movie",
                fontSize = 32.sp,
                maxLines = 2,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                color = dominantTextColor
            )


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
        }
    }


}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun playingnowPreview() {
    MovieShopTheme {
        TopPlayingNowSectionItem(modifier = Modifier, movie =
        Movie(1,"title","posterpath",
            "23.9.2022",
            3.5,5.0,"abcdefghijklmn",3),
            moviesState = MovieState(), onClickItem = {})
    }
}
