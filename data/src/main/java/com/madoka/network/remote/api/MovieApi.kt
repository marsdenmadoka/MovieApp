package com.madoka.network.remote.api

import com.madoka.network.remote.dto.MovieDto
import com.madoka.network.remote.dto.NowPlayingMoviesDto
import com.madoka.network.remote.dto.PopularMoviesDto
import com.madoka.network.remote.dto.TrendingMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response

interface MovieApi {

    /* get now playing movies */
    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(
        @Query("page") page: Int = 1,
    ): NowPlayingMoviesDto

    /**
    //get now playing movies :: use this when we want to save to local db
    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(
        @Query("page") page: Int = 1,
    ): Response<NowPlayingMoviesDto>
     **/

    /*get trending movies*/
    @GET("trending/{media_type}/{time_window}")
    suspend fun fetchTrendingMovies(
        @Path("media_type") mediaType: String = "movie",
        @Path("time_window") timeWindow: String = "day",
        @Query("page") page: Int = 1,
    ): TrendingMoviesDto


    /*get popular movies*/
    @GET("movie/popular")
    suspend fun fetchPopularMovies(
        @Query("page") page: Int = 1,
    ): PopularMoviesDto


    /*get Movie Details */
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id:Int
    ):MovieDto


//    @GET("/v1/coins/{coinId}")
//    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}