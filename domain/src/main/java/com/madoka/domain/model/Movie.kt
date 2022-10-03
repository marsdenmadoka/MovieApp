package com.madoka.domain.model

data class Movie(
    val movieId: Int,
    val title: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double?,
    val popularity: Double,
    val overview: String,
    val runtime: Int

)
