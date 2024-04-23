package com.madoka.movieshop.components;

import androidx.compose.foundation.Image;
import androidx.compose.foundation.background;
import androidx.compose.foundation.clickable;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.getValue;
import androidx.compose.runtime.mutableStateOf;
import androidx.compose.runtime.remember;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.LocalContext;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;
import androidx.constraintlayout.compose.Dimension;
import androidx.navigation.NavController;
import coil.request.ImageRequest;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import com.gowtham.ratingbar.RatingBarConfig;
import com.gowtham.ratingbar.RatingBarStyle;
import com.gowtham.ratingbar.StepSize;
import com.madoka.domain.model.Movie;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a8\u0006\b"}, d2 = {"PopularMovieItem", "", "movie", "Lcom/madoka/domain/model/Movie;", "navController", "Landroidx/navigation/NavController;", "onClickItem", "Lkotlin/Function1;", "app_debug"})
public final class PopularMoviesItemKt {
    
    @androidx.compose.runtime.Composable
    public static final void PopularMovieItem(@org.jetbrains.annotations.NotNull
    com.madoka.domain.model.Movie movie, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.madoka.domain.model.Movie, kotlin.Unit> onClickItem) {
    }
}