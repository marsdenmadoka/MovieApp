package com.madoka.domain.repository

interface NowPlayingMovieRepository {

    suspend fun getPlayingNowMovies():List
}