package com.madoka.domain.usecase

import com.madoka.domain.repository.MovieRepository
import javax.inject.Inject

class NowPlayingMovieDetailUseCase @Inject constructor(private val MoviesRepository: MovieRepository){
}