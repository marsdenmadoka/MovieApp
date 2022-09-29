package com.madoka.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.madoka.domain.model.Movie

data class MovieDto(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)



// @SerializedName("poster_path") // val poster_path: String,