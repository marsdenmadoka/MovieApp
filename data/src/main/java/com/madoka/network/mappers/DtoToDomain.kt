package com.madoka.network.mappers

import com.madoka.commons.IMAGE_URL
import com.madoka.network.remote.dto.MovieDto
import com.madoka.network.remote.dto.NowPlayingMoviesDto
import com.madoka.domain.model.Movie
import com.madoka.domain.model.NowPlayingMovies

//DtoToDomain mappers
/*When we use Cache Data together with remote data we might not need this class
* we will only need DtoToEntity and EntityToDomain*/
/**Since all our responses have same moviesTtype will use the same mapper/converter*/
fun MovieDto.toMovie(): Movie {
    return Movie(
        movieId = id,
        title = title,
        posterPath = IMAGE_URL + posterPath,
        releaseDate = releaseDate ,  //.substringBefore("-") ?: ""
        voteAverage= voteAverage ,
        popularity = popularity,
         overview = overview,
        runtime=runtime

    )
}


fun NowPlayingMoviesDto.toDomain(): NowPlayingMovies {
    return NowPlayingMovies(
        page = page,
        movies = movies.map { it.toMovie() }
    )
}

