package com.madoka.movieshop.ui.screens.home

import com.madoka.domain.model.Movie

data class MovieState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null

)