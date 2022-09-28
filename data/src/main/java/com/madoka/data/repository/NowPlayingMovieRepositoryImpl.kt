package com.madoka.data.repository

import com.madoka.commons.Resource
import com.madoka.data.mappers.toMovie
import com.madoka.data.remote.api.MovieApi
import com.madoka.data.util.SafeApiRequest
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.NowPlayingMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class NowPlayingMovieRepositoryImpl(private val movieApiService: MovieApi) :
    NowPlayingMovieRepository{
    override suspend fun getPlayingNowMovies(): Flow<Resource<List<Movie>>> = flow {
       //TODO make sure to add a safe api request!! to avoid blocking ui
        emit(Resource.Loading())
        try {
            val responseData = movieApiService.fetchNowPlayingMovies()
            emit(Resource.Success(responseData.movies.map { it.toMovie() }))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server, please check your internet connection!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        }

//        val response = safeApiRequest {
//            movieApiService.fetchNowPlayingMovies()
//        }.toNowPlayingMovies()
//
//        emit(Resource.Loading())
//        try {
//            val response = movieApiService.fetchNowPlayingMovies()
//            emit(Resource.Success(respo))
//        }
    }


}