package com.madoka.domain.di

import com.madoka.domain.model.NowPlayingMovies
import com.madoka.domain.repository.NowPlayingMovieRepository
import com.madoka.domain.usecase.NowPlayingMovieDetailUseCase
import com.madoka.domain.usecase.NowPlayingMovieListUseCase
import com.madoka.domain.usecase.TrendingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideNowPlayingMovieListUseCase(nowPlayingMovieReposiory: NowPlayingMovieRepository) =
        NowPlayingMovieListUseCase(nowPlayingMovieReposiory)

    @Provides
    @Singleton
    fun provideNowPlayingMovieDetailUseCase(nowPlayingMovieReposiory: NowPlayingMovieRepository) =
        NowPlayingMovieDetailUseCase(nowPlayingMovieReposiory)

    @Provides
    @Singleton
    fun provideTrendingMoviesUseCase(TrendingMovieRepository: NowPlayingMovieRepository) =
        TrendingMoviesUseCase(TrendingMovieRepository)


}