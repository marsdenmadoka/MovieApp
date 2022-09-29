package com.madoka.domain.usecase

import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.NowPlayingMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrendingMoviesUseCase @Inject constructor(private val nowPlayingMoviesRepository: NowPlayingMovieRepository) {

    suspend operator fun invoke(): Flow<Resource<List<Movie>>> {
        return nowPlayingMoviesRepository.getTrendingMovies()
    }

}