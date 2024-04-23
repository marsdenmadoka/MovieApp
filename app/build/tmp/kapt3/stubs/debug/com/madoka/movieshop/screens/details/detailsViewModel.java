package com.madoka.movieshop.screens.details;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope;
import com.madoka.commons.Resource;
import com.madoka.domain.usecase.MovieDetailUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.asStateFlow;
import kotlinx.coroutines.flow.collectLatest;
import kotlinx.coroutines.launch;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/madoka/movieshop/screens/details/detailsViewModel;", "Landroidx/lifecycle/ViewModel;", "movieDetailUseCase", "Lcom/madoka/domain/usecase/MovieDetailUseCase;", "(Lcom/madoka/domain/usecase/MovieDetailUseCase;)V", "_movieDetailState", "error/NonExistentClass", "Lerror/NonExistentClass;", "movieDetailState", "getMovieDetailState", "()Lerror/NonExistentClass;", "getMovieDetail", "", "movieId", "", "app_debug"})
public final class detailsViewModel extends androidx.lifecycle.ViewModel {
    private final com.madoka.domain.usecase.MovieDetailUseCase movieDetailUseCase = null;
    private final java.lang.Object _movieDetailState = null;
    
    @javax.inject.Inject
    public detailsViewModel(@org.jetbrains.annotations.NotNull
    com.madoka.domain.usecase.MovieDetailUseCase movieDetailUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getMovieDetailState() {
        return null;
    }
    
    public final void getMovieDetail(int movieId) {
    }
}