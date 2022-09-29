package com.madoka.data.remote.api

import com.madoka.data.remote.dto.MovieDto
import com.madoka.data.remote.dto.NowPlayingMoviesDto
import com.madoka.data.remote.dto.TrendingMoviesDto
import com.madoka.domain.model.NowPlayingMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {


    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(
        @Query("page") page: Int = 1,
    ): NowPlayingMoviesDto



    @GET("movie/now_playing")
    suspend fun fetchTrendingMovies(
        @Path("media_type") mediaType: String = "movie",
        @Path("time_window") timeWindow: String = "day",
        @Query("page") page: Int = 1,
    ):TrendingMoviesDto


}