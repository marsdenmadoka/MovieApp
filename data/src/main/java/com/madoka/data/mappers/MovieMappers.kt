package com.madoka.data.mappers

import com.madoka.commons.IMAGE_URL
import com.madoka.data.remote.dto.MovieDto
import com.madoka.data.remote.dto.NowPlayingMoviesDto
import com.madoka.domain.model.Movie
import com.madoka.domain.model.NowPlayingMovies


/**Since all our responses have same moviesTtype will use the same mapper/converter*/
fun MovieDto.toMovie(): Movie {
    return Movie(
        movieId = id,
        title = title,
        posterPath = IMAGE_URL + posterPath,
        releaseDate = releaseDate   //.substringBefore("-") ?: ""


    )
}


fun NowPlayingMoviesDto.toDomain(): NowPlayingMovies {
    return NowPlayingMovies(
        page = page,
        movies = movies.map { it.toMovie() }
    )
}


