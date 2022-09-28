package com.madoka.domain.usecase

import com.madoka.domain.repository.NowPlayingMovieRepository
import javax.inject.Inject

class NowPlayingMovieDetailUseCase @Inject constructor(private val nowPlayingMoviesRepository: NowPlayingMovieRepository){
}