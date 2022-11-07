package com.madoka.movieshop.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.madoka.domain.model.Movie
import com.madoka.movieshop.components.Separator
import com.madoka.movieshop.components.TopPlayingNowSectionItem
import com.madoka.movieshop.components.TrendingMoviesItem
import com.madoka.movieshop.components.PopularMovieItem
import com.madoka.movieshop.screens.details.detailsScreen
import com.madoka.movieshop.ui.theme.DeepBlue


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
//    val playingNowMovieState = viewModel.moviePlayingNowState.value
//    val trendingMovieState = viewModel.movieTrendingState.value
//    val popularMovieState = viewModel.moviePopularState.value

    val playingNowMovieState = viewModel.moviePlayingNowState.collectAsState().value
    val trendingMovieState = viewModel.movieTrendingState.collectAsState().value
    val popularMovieState = viewModel.moviePopularState.collectAsState().value

    val scrollState = rememberScrollState()
    Surface(
        //picks the color depending on  light mode or dark mode
        color = MaterialTheme.colors.surface,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            // .paddingFromBaseline(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopSectionPlayingNow(
                moviesState = playingNowMovieState,
                navController = navController
            )
            TrendingNowMovies(
                moviesSate = trendingMovieState,
                navController = navController,
            )
            PopularMovies(
                moviesSate = popularMovieState,
                navController = navController
            )
            Spacer(modifier = Modifier.height(18.dp))
        }
    }

}



@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TopSectionPlayingNow(
    moviesState: MovieState,
    navController: NavController,
) {

    val pagerState = rememberPagerState()
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .placeholder(
                visible = moviesState.isLoading,//false,
                color = Color.White,
                highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
            ),
        count = if (moviesState.movies.size >= 5) 5 else moviesState.movies.size,
        state = pagerState
    )
    { page ->
//        TopPlayingNowSectionItem(movie = , moviesState = , onClickItem = )
        TopPlayingNowSectionItem(
            modifier = Modifier
                .fillMaxSize(),
            movie = moviesState.movies[page],
            moviesState = moviesState
        ) { movie ->
             val items = moviesState.movies[page]
            navController.navigate("details/${movie.movieId}")
        }
    }

    Spacer(modifier = Modifier.height(6.dp))

    HorizontalPagerIndicator(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(0.15f),
        pagerState = pagerState,
        indicatorHeight = 6.dp,
        indicatorWidth = 6.dp,
        spacing = 6.dp,
        activeColor = DeepBlue,
        inactiveColor = Gray
    )

}

@Composable
fun TrendingNowMovies(
    moviesSate: MovieState,
    navController: NavController,
) {
    //separate our sections class created in components
    Separator(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 12.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        sectionTitle = "Trending Movies",
        onItemClick = { /** navigate to view all**/ }
    )
    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .placeholder(
                visible = moviesSate.isLoading,//false,
                color = Color.White,
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
            )
    ) {
        items(moviesSate.movies) { item ->
            TrendingMoviesItem(
                movie = item,
                onClickItem = { movie ->
                    navController.navigate("details/${movie.movieId}")
                    //navController.navigate("details/${movie.id!!}/${movie.cacheId}")
                },
            )
        }
    }
}

@Composable
fun PopularMovies(
    moviesSate: MovieState,
    navController: NavController
) {
    Separator(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 12.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        sectionTitle = "Popular Movies",
        onItemClick = {
            // click to view all
        }
    )

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier
            .wrapContentHeight()
            .placeholder(
                visible = moviesSate.isLoading, //false,
                color = Gray,
                highlight = PlaceholderHighlight.fade(highlightColor = Color.White)
            )
    ) {
        items(moviesSate.movies) { item ->
            PopularMovieItem(
                movie = item,
                onClickItem = { movie ->
                    navController.navigate("details/${movie.movieId}")
                },
                navController = navController
            )
        }
    }
}


