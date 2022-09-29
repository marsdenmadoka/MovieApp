package com.madoka.domain.usecase

import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrendingMoviesUseCase @Inject constructor(private val MoviesRepository: MovieRepository) {

    suspend operator fun invoke(): Flow<Resource<List<Movie>>> {
        return MoviesRepository.getTrendingMovies()
    }

}