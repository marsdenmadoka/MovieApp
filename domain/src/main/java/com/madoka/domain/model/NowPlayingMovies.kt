package com.madoka.domain.model

/**we can consider reusing this class instead of creating new ones for each DTO
 i.e popularmovies,Trendingmovies
 * this is because all Our DTOs have the same/similar properties types*/
data class NowPlayingMovies(
     val page: Int,
    val movies: List<Movie>
)

