package com.madoka.network.repository

import com.madoka.cache.AppDatabase
import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.MovieRepository
import com.madoka.network.mappers.toMovie
import com.madoka.network.remote.api.MovieApi
import com.madoka.network.util.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NowPlayingMovieRepositoryImpl @Inject constructor(
    private val movieApiService: MovieApi,
    private val appDatabase: AppDatabase
) : MovieRepository /*,SafeApiRequest()**/ {

    override suspend fun getPlayingNowMovies(): Flow<Resource<List<Movie>>> = flow {

        //TODO 1.make sure to add a safe api request!! to avoid blocking ui
        // 2.save and retrieve this to a local database,the room code is provided in cache dir

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

    override suspend fun getMovieDetail(movieId: Int): Flow<Resource<Movie>> = flow {
        emit(Resource.Loading())
        try {
            val responseData = movieApiService.getMovieDetails(movieId)
            emit(Resource.Success(responseData.toMovie()))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server, please check your internet connection!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        }

    }

/*
    //saving our nowPlaying movies to localdb
    private val moviesDao = appDatabase.MoviesDao()
    private val nowPlayingMoviesLivedata = MutableLiveData<List<MovieEntity>>()

    init {
        nowPlayingMoviesLivedata.observeForever {
            Coroutines.io { saveNowPlayingMovies(it) }
        }
    }

    private suspend fun saveNowPlayingMovies(movies: List<MovieEntity>) =
        moviesDao.saveMovies(movieEntities = movies)


    override suspend fun getPlayingNowMovies(): Flow<List<Movie>> {
        val isCategoryCacheAvailable = moviesDao.isCategoryCacheAvailable("now_playing") > 0

        return if (isCategoryCacheAvailable) {
            val cacheResponse = moviesDao.getMovies("now_playing")
            cacheResponse.map { it.map { it.toDomain() } }
        } else {
            val networkResponse = safeApiRequest { movieApiService.fetchNowPlayingMovies() }
                .movies.map { it.toEntity(category = "now_playing") }
            nowPlayingMoviesLivedata.value = networkResponse!!

            val cacheResponse = moviesDao.getMovies("now_playing")

            cacheResponse.map { it.map { it.toDomain() } }
        }
    }

    */


}