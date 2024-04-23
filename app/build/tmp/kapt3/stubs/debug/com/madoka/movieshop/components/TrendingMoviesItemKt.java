package com.madoka.movieshop.components;

import android.content.res.Configuration;
import androidx.compose.foundation.clickable;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.LocalContext;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;
import coil.request.ImageRequest;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import com.madoka.domain.model.Movie;
import com.madoka.movieshop.screens.home.MovieState;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0007\u00a8\u0006\u0007"}, d2 = {"TrendingMoviesItem", "", "movie", "Lcom/madoka/domain/model/Movie;", "onClickItem", "Lkotlin/Function1;", "TrendingnowPreview", "app_debug"})
public final class TrendingMoviesItemKt {
    
    @androidx.compose.runtime.Composable
    public static final void TrendingMoviesItem(@org.jetbrains.annotations.NotNull
    com.madoka.domain.model.Movie movie, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.madoka.domain.model.Movie, kotlin.Unit> onClickItem) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void TrendingnowPreview() {
    }
}