package com.madoka.network.remote.dto

import com.google.gson.annotations.SerializedName

/*single movie properties*/
data class MovieDto(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,

    @SerializedName("original_language")
    val  originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val runtime: Int,
    val popularity: Double,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    val vote_count: Int
)



// @SerializedName("poster_path") // val poster_path: String,