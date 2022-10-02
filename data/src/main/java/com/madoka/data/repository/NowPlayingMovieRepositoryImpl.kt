package com.madoka.data.repository

import com.madoka.commons.Resource
import com.madoka.data.mappers.toMovie
import com.madoka.data.remote.api.MovieApi
//import com.madoka.data.util.SafeApiRequest
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NowPlayingMovieRepositoryImpl @Inject constructor(private val movieApiService: MovieApi) :
    MovieRepository{
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

    }

    override suspend fun getTrendingMovies(): Flow<Resource<List<Movie>>> = flow {
        //TODO make sure to add a safe api request!! to avoid blocking ui
        emit(Resource.Loading())
        try {
            val responseData = movieApiService.fetchTrendingMovies()
            emit(Resource.Success(responseData.movies.map { it.toMovie() }))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server, please check your internet connection!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        }

    }

    override suspend fun getPopularMovies(): Flow<Resource<List<Movie>>> = flow {

        emit(Resource.Loading())
        try {
            val responseData = movieApiService.fetchPopularMovies()
            emit(Resource.Success(responseData.movies.map { it.toMovie() }))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server, please check your internet connection!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        }
    }

    override suspend fun getMovieDetail(movieId:Int): Flow<Resource<Movie>> = flow {
       emit(Resource.Loading())

        try {
            val responseData = movieApiService.getMovieDetails(movieId)
            emit(Resource.Success(responseData.toMovie()))
        }catch (e: IOException){
            emit(Resource.Error(message = "Could not reach the server, please check your internet connection!"))
        }catch (e:HttpException){
            emit(Resource.Error(message = "Oops, something went wrong!"))
        }

    }


}