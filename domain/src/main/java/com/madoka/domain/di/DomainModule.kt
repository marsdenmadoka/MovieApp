package com.madoka.domain.di

import com.madoka.domain.repository.MovieRepository
import com.madoka.domain.usecase.NowPlayingMovieDetailUseCase
import com.madoka.domain.usecase.NowPlayingMovieListUseCase
import com.madoka.domain.usecase.TrendingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**Inject our use cases*/
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideNowPlayingMovieListUseCase(MovieRepository: MovieRepository) =
        NowPlayingMovieListUseCase(MovieRepository)

    @Provides
    @Singleton
    fun provideNowPlayingMovieDetailUseCase(MovieRepository: MovieRepository) =
        NowPlayingMovieDetailUseCase(MovieRepository)

    @Provides
    @Singleton
    fun provideTrendingMoviesUseCase(MovieRepository: MovieRepository) =
        TrendingMoviesUseCase(MovieRepository)


}