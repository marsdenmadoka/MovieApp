package com.madoka.domain.usecase

import com.madoka.domain.repository.NowPlayingMovieRepository
import javax.inject.Inject

class NowPlayingMovieListUseCase @Inject constructor(private val nowplayinmoviesRepostory:NowPlayingMovieRepository){
}