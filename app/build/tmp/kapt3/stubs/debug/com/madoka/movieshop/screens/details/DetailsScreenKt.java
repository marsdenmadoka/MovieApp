package com.madoka.movieshop.screens.details;

import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.LocalContext;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;
import androidx.constraintlayout.compose.Dimension;
import androidx.navigation.NavController;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import com.madoka.domain.model.Movie;
import com.madoka.movieshop.utils.PaletteGenerator;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0003\u001a \u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u000e"}, d2 = {"DetailsScreenPreview", "", "MoviePoster", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavController;", "moviedetailstate", "Lcom/madoka/movieshop/screens/details/MovieDetailState;", "detailsScreen", "movieId", "", "detailsviewModel", "Lcom/madoka/movieshop/screens/details/detailsViewModel;", "app_debug"})
public final class DetailsScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void detailsScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, int movieId, @org.jetbrains.annotations.NotNull
    com.madoka.movieshop.screens.details.detailsViewModel detailsviewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void MoviePoster(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    com.madoka.movieshop.screens.details.MovieDetailState moviedetailstate) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(name = "details screen")
    private static final void DetailsScreenPreview() {
    }
}