package com.madoka.domain.usecase

import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.NowPlayingMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NowPlayingMovieListUseCase @Inject constructor(private val nowplayinmoviesRepostory: NowPlayingMovieRepository) {

    suspend operator fun invoke(): Flow<Resource<List<Movie>>> {
        return nowplayinmoviesRepostory.getPlayingNowMovies()
    }
}