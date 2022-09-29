package com.madoka.movieshop.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madoka.commons.Resource
import com.madoka.domain.usecase.NowPlayingMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val playingNowUseCase: NowPlayingMovieListUseCase
) : ViewModel() {
    private val _movieState = mutableStateOf(MovieState())
    val movieState: State<MovieState> = _movieState

    init {
        getPlayingNowMovies()
    }

    private fun getPlayingNowMovies() {
        viewModelScope.launch {
            playingNowUseCase().collectLatest { result ->
                when (result) {
                    is com.madoka.commons.Resource.Success -> {
                        _movieState.value = movieState.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false

                        )
                    }
                    is com.madoka.commons.Resource.Loading -> {
                        _movieState.value = movieState.value.copy(
                            isLoading = true
                        )
                    }
                    is com.madoka.commons.Resource.Error -> {
                        _movieState.value =movieState.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occured"
                        )
                    }
                }
            }
        }
    }

}