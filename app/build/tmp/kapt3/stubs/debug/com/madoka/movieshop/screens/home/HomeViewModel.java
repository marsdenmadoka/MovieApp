package com.madoka.movieshop.screens.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope;
import com.madoka.commons.Resource;
import com.madoka.domain.usecase.NowPlayingMovieListUseCase;
import com.madoka.domain.usecase.PopularMoviesUseCase;
import com.madoka.domain.usecase.TrendingMoviesUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.collectLatest;
import kotlinx.coroutines.launch;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/madoka/movieshop/screens/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "playingNowUseCase", "Lcom/madoka/domain/usecase/NowPlayingMovieListUseCase;", "TrendingMovieUseCase", "Lcom/madoka/domain/usecase/TrendingMoviesUseCase;", "PopularMovieUsesCase", "Lcom/madoka/domain/usecase/PopularMoviesUseCase;", "(Lcom/madoka/domain/usecase/NowPlayingMovieListUseCase;Lcom/madoka/domain/usecase/TrendingMoviesUseCase;Lcom/madoka/domain/usecase/PopularMoviesUseCase;)V", "_moviePlayingNowState", "error/NonExistentClass", "Lerror/NonExistentClass;", "_moviePopularState", "_movieTrendingState", "moviePlayingNowState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/madoka/movieshop/screens/home/MovieState;", "getMoviePlayingNowState", "()Lkotlinx/coroutines/flow/StateFlow;", "moviePopularState", "getMoviePopularState", "movieTrendingState", "getMovieTrendingState", "getPlayingNowMovies", "", "popularNowMovies", "trendingNowMovies", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.madoka.domain.usecase.NowPlayingMovieListUseCase playingNowUseCase = null;
    private final com.madoka.domain.usecase.TrendingMoviesUseCase TrendingMovieUseCase = null;
    private final com.madoka.domain.usecase.PopularMoviesUseCase PopularMovieUsesCase = null;
    private final java.lang.Object _moviePlayingNowState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.madoka.movieshop.screens.home.MovieState> moviePlayingNowState = null;
    private final java.lang.Object _movieTrendingState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.madoka.movieshop.screens.home.MovieState> movieTrendingState = null;
    private final java.lang.Object _moviePopularState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.madoka.movieshop.screens.home.MovieState> moviePopularState = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.madoka.domain.usecase.NowPlayingMovieListUseCase playingNowUseCase, @org.jetbrains.annotations.NotNull
    com.madoka.domain.usecase.TrendingMoviesUseCase TrendingMovieUseCase, @org.jetbrains.annotations.NotNull
    com.madoka.domain.usecase.PopularMoviesUseCase PopularMovieUsesCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.madoka.movieshop.screens.home.MovieState> getMoviePlayingNowState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.madoka.movieshop.screens.home.MovieState> getMovieTrendingState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.madoka.movieshop.screens.home.MovieState> getMoviePopularState() {
        return null;
    }
    
    private final void getPlayingNowMovies() {
    }
    
    private final void trendingNowMovies() {
    }
    
    private final void popularNowMovies() {
    }
}