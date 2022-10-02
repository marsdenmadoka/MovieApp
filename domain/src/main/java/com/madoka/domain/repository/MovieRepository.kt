package com.madoka.domain.repository

import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    //we are not implementing paging data yet so we use list instead of paging
    suspend fun getPlayingNowMovies(): Flow<Resource<List<Movie>>>

    suspend fun getTrendingMovies(): Flow<Resource<List<Movie>>>

    suspend fun getPopularMovies(): Flow<Resource<List<Movie>>>

    suspend fun getMovieDetail(movieId: Int): Flow<Resource<Movie>>
}