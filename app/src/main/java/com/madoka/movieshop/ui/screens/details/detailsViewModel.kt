package com.madoka.movieshop.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import com.madoka.domain.usecase.MovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class detailsViewModel @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) :
    ViewModel() {
//    private val _movieDetails = MutableStateFlow<Movie>(null)
//    val movieDetails get() = _movieDetails.asStateFlow()


    private val _movieDetailState = MutableStateFlow(MovieDetailState())
    val movieDetailState get() = _movieDetailState.asStateFlow()
            //StateFlow<MovieDetailState> = _movieDetailState


    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            movieDetailUseCase(movieId).collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _movieDetailState.value = movieDetailState.value.copy(
                            movie = result.data,
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _movieDetailState.value = movieDetailState.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _movieDetailState.value = movieDetailState.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }

                }
            }
        }
    }
}
