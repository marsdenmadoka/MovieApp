package com.madoka.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.madoka.domain.model.Movie
import com.madoka.domain.model.NowPlayingMovies

data class NowPlayingMoviesDto(

    val dates: Dates,

    val page: Int,

    @SerializedName("results")
    val movies: List<MovieDto>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
)

fun NowPlayingMoviesDto.toNowPlayingMovies() : NowPlayingMovies {
    return NowPlayingMovies(
        page=page ,
        movieslis = movies.map { it.toMovie() }
    )
}