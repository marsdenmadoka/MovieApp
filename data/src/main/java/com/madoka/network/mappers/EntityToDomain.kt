package com.madoka.network.mappers

import com.madoka.cache.models.MovieEntity
import com.madoka.cache.models.MoviesEntity
import com.madoka.commons.IMAGE_URL
import com.madoka.domain.model.Movie
import com.madoka.domain.model.NowPlayingMovies

internal fun MovieEntity.toDomain(): Movie {
    return Movie(
        movieId = id,
        title = title,
        posterPath = IMAGE_URL + posterPath,
        releaseDate = releaseDate,  //.substringBefore("-") ?: ""
        voteAverage = voteAverage,
        popularity = popularity,
        overview = overview,
        runtime = runtime

    )
}

/*
* our Now_playing movies,Trending movies,Popular movies all have
* the same properties therefore we can choose to create ONE moviesMAPPER FUNCTION that will
* define/represent all other movies instead of creating separate functions with same properties
* */

internal fun MoviesEntity.toDomain() : NowPlayingMovies {
    return NowPlayingMovies(
        page = page,
    movies = movies!!.map { it.toDomain() }
    )
}





/*
internal fun NowPlayingMoviesEntity.toDomain(): NowPlayingMovies {
    return NowPlayingMovies(
        this.dates?.toDomain(),
        this.page,
        this.movies?.map { it.toDomain() },
        this.totalPages,
        this.totalResults
    )
}

internal fun PopularMoviesEntity.toDomain(): PopularMovies {
    return PopularMovies(
        this.page,
        this.movies?.map { it.toDomain() },
        this.totalPages,
        this.totalResults
    )

 */
