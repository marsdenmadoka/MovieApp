package com.madoka.movieshop.screens.details

import com.madoka.domain.model.Movie

data class MovieDetailState(
    val movie: Movie? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
