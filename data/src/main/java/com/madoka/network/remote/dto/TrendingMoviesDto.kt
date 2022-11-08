package com.madoka.network.remote.dto

import com.google.gson.annotations.SerializedName

data class TrendingMoviesDto(
    val page: Int,

    @SerializedName("results")
    val movies: List<MovieDto>,

    val total_pages: Int,

    val total_results: Int
)
//val results: List<Result>,