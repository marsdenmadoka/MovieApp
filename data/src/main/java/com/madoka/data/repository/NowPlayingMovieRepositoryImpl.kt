package com.madoka.data.repository

import com.madoka.commons.Resource
import com.madoka.data.remote.api.MovieApi
import com.madoka.data.util.SafeApiRequest
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.NowPlayingMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class NowPlayingMovieRepositoryImpl(private val movieApiService:MovieApi)
    :NowPlayingMovieRepository ,SafeApiRequest(){

    override suspend fun getPlayingNowMovies(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
          try {
            val response = movieApiService.fetchNowPlayingMovies()
            //emit(Resource.Success(response.isSuccessful))

        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server, please check your internet connection!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        }

        movieApiService.fetchNowPlayingMovies()

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