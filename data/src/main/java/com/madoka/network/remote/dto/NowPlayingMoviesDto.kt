package com.madoka.network.remote.dto

import com.google.gson.annotations.SerializedName

/*we can all choose to have ONE MoviesDTO(s) to represent NowPlayingMoviesDTO,
 PopularMoviesDto and TrendingMoviesDto this is because there all have same
* properties */
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

