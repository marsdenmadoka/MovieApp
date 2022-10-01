package com.madoka.movieshop.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madoka.commons.Resource
import com.madoka.domain.usecase.NowPlayingMovieListUseCase
import com.madoka.domain.usecase.PopularMoviesUseCase
import com.madoka.domain.usecase.TrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val playingNowUseCase: NowPlayingMovieListUseCase,
    private val TrendingMovieUseCase: TrendingMoviesUseCase,
    private val PopularMovieUsesCase: PopularMoviesUseCase
) : ViewModel() {

//    private val _moviePlayingNowState = mutableStateOf(MovieState())
//    val moviePlayingNowState: State<MovieState> = _moviePlayingNowState

//    private val _movieTrendingState = mutableStateOf(MovieState())
//    val movieTrendingState: State<MovieState> = _movieTrendingState

//    private val _moviePopularState = mutableStateOf(MovieState())
//    val moviePopularState: State<MovieState> = _moviePopularState

    private val _moviePlayingNowState = MutableStateFlow(MovieState())
    val moviePlayingNowState: StateFlow<MovieState> = _moviePlayingNowState

    private val _movieTrendingState = MutableStateFlow(MovieState())
    val movieTrendingState: StateFlow<MovieState> = _movieTrendingState


    private val _moviePopularState = MutableStateFlow(MovieState())
    val moviePopularState: StateFlow<MovieState> = _moviePopularState

    init {
        getPlayingNowMovies()
        trendingNowMovies()
        popularNowMovies()

    }

private fun getPlayingNowMovies() {
        viewModelScope.launch {
            playingNowUseCase().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _moviePlayingNowState.value = moviePlayingNowState.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false

                        )
                    }
                    is Resource.Loading -> {
                        _moviePlayingNowState.value = moviePlayingNowState.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _moviePlayingNowState.value = moviePlayingNowState.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                }
            }
        }
    }



    private fun trendingNowMovies() {
        viewModelScope.launch {
            TrendingMovieUseCase().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _movieTrendingState.value = movieTrendingState.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _movieTrendingState.value = movieTrendingState.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _movieTrendingState.value =movieTrendingState.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                }
            }
        }
    }





    private fun popularNowMovies() {
        viewModelScope.launch {
            PopularMovieUsesCase().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _moviePopularState.value = moviePopularState.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _moviePopularState.value = moviePopularState.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _moviePopularState.value = moviePopularState.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                }
            }
        }
    }

}