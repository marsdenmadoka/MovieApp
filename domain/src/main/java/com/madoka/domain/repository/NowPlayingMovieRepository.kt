package com.madoka.domain.repository

import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface NowPlayingMovieRepository {

    //we are not implementing paging data yet so we use list instead of paging
      suspend fun getPlayingNowMovies(): Flow<Resource<List<Movie>>>

}