package com.madoka.domain.usecase

import com.madoka.commons.Resource
import com.madoka.domain.model.Movie
import com.madoka.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(private val MoviesRepository: MovieRepository){

    suspend operator fun invoke(movieId:Int): Flow<Resource<Movie>> {
        return MoviesRepository.getMovieDetail(movieId)
    }

}