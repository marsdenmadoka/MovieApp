package com.madoka.domain.model

data class Movie(
    val movieId: Int,
    val title: String,
    val posterPath: String?,
    val backdrop_path: String,
    val originalTitle: String,
)
