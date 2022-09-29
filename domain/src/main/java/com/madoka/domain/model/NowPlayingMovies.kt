package com.madoka.domain.model

/**we can consider reusing this class instead of creating new ones for each DTO
 * this is because all Our DTOs have the same/similar variable types*/
data class NowPlayingMovies(
     val page: Int,
    val movies: List<Movie>
)

