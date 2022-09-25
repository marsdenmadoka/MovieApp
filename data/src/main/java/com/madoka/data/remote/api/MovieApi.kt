package com.madoka.data.remote.api

import com.madoka.data.remote.dto.NowPlayingMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {


    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("language") language: String = "en"
    ): Response<NowPlayingMoviesDto>


//    @GET("discover/movie")
//    suspend fun getMovies(
//        @Query("page") page: Int? = null,
//    ): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int
    ): MovieDetailResponse
}