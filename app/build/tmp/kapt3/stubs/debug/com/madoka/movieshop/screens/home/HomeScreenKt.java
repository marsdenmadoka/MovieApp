package com.madoka.movieshop.screens.home;

import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyRow;
import androidx.compose.foundation.lazy.items;
import androidx.compose.foundation.rememberScrollState;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.verticalScroll;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.collectAsState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.unit.dp;
import androidx.navigation.NavController;
import com.google.accompanist.pager.ExperimentalPagerApi;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import com.madoka.domain.model.Movie;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0003\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u00a8\u0006\r"}, d2 = {"HomeScreen", "", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/madoka/movieshop/screens/home/HomeViewModel;", "HomeScreenPreview", "PopularMovies", "moviesSate", "Lcom/madoka/movieshop/screens/home/MovieState;", "TopSectionPlayingNow", "moviesState", "TrendingNowMovies", "app_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    com.madoka.movieshop.screens.home.HomeViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    private static final void TopSectionPlayingNow(com.madoka.movieshop.screens.home.MovieState moviesState, androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TrendingNowMovies(@org.jetbrains.annotations.NotNull
    com.madoka.movieshop.screens.home.MovieState moviesSate, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PopularMovies(@org.jetbrains.annotations.NotNull
    com.madoka.movieshop.screens.home.MovieState moviesSate, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(name = "Home screen")
    private static final void HomeScreenPreview() {
    }
}