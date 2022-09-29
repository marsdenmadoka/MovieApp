package com.madoka.data.mappers

import com.madoka.data.remote.dto.MovieDto
import com.madoka.data.remote.dto.NowPlayingMoviesDto
import com.madoka.domain.model.Movie
import com.madoka.domain.model.NowPlayingMovies


fun MovieDto.toMovie(): Movie {
    return Movie(
        movieId = id,
        title = title,
        posterPath = posterPath,
        backdrop_path = backdrop_path,
        originalTitle = originalTitle,
    )
}


fun NowPlayingMoviesDto.toDomain(): NowPlayingMovies {
    return NowPlayingMovies(
        page = page,
        movies = movies.map { it.toMovie() }
    )
}