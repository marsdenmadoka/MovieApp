package com.madoka.cache.models

/*
* our Now_playing movies,Trending movies,Popular movies all have
* the same properties therefore we can choose to create ONE moviesEntity class that will
* define/represent all other movies instead of creating separate classes with same properties
* */
data class MoviesEntity(
    val page: Int,

    val movies: List<MovieEntity>?,

    val totalPages: Int?,

    val totalResults: Int?

)