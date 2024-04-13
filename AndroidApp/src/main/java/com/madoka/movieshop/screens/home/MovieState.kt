package com.madoka.movieshop.screens.home

import com.madoka.domain.model.Movie

data class MovieState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null

)
//sealed class MovieState {
//    object Loading : MovieState()
//    data class Success(val movies: List<Movie>) : MovieState()
//    data class Error(val error: String) : MovieState()
//}