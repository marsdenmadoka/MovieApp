package com.madoka.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movies Table")
data class MovieEntity(
    val adult: Boolean?,

    val backdropPath: String?,

    val id: Int,

    val originalLanguage: String?,

    val originalTitle: String?,

    val overview: String,

    val popularity: Double,

    val posterPath: String?,

    val runtime: Int,

    val releaseDate: String,

    val title: String,

    val video: Boolean?,

    val voteAverage: Double?,

    val voteCount: Int?,

    val category: String?,

    val isFavorite: Boolean?,

    @PrimaryKey(autoGenerate = true)
    val cacheId:Int=0
)
