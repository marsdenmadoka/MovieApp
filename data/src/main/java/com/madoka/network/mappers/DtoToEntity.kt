package com.madoka.network.mappers

import com.madoka.cache.models.MovieEntity
import com.madoka.cache.models.MoviesEntity
import com.madoka.commons.IMAGE_URL
import com.madoka.network.remote.dto.MovieDto
import com.madoka.network.remote.dto.NowPlayingMoviesDto


///////////////////////////
/**Dto to Entity*/

fun MovieDto.toEntity(category: String? = null): MovieEntity {

    return MovieEntity(
        adult = adult,
        backdropPath = backdrop_path,
        genreIds = genre_ids,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = IMAGE_URL + posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = vote_count,
        runtime = runtime,
        category = category,
        isFavorite = false


    )
}

fun NowPlayingMoviesDto.toEntity(): MoviesEntity {
    return MoviesEntity(
//        dates = Dates,
        page = page,
        movies = movies.map { it.toEntity() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}





/*
/*
* our Now_playing movies,Trending movies,Popular movies all have
* the same properties therefore we can choose to create ONE moviesMAPPER FUNCTION that will
* define/represent all other movies instead of creating separate functions with same properties
* */
internal fun NowPlayingMoviesDto.toEntity(): NowPlayingMoviesEntity {
    return NowPlayingMoviesEntity(
        this.dates?.toEntity(),
        this.page,
        this.movies?.map { it.toEntity() },
        this.totalPages,
        this.totalResults
    )
}

internal fun PopularMoviesDto.toEntity(): PopularMoviesEntity {
    return PopularMoviesEntity(
        this.page,
        this.movies?.map { it.toEntity() },
        this.totalPages,
        this.totalResults
    )
}
*/