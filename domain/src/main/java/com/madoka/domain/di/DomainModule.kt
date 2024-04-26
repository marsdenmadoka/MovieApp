package com.madoka.domain.di

import com.madoka.domain.repository.MovieRepository
import com.madoka.domain.usecase.MovieDetailUseCase
import com.madoka.domain.usecase.NowPlayingMovieListUseCase
import com.madoka.domain.usecase.PopularMoviesUseCase
import com.madoka.domain.usecase.TrendingMoviesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**Inject our use cases*/
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    //@Binds
    @Provides
    @Singleton
    fun provideNowPlayingMovieListUseCase(MovieRepository: MovieRepository) =
        NowPlayingMovieListUseCase(MovieRepository)

    //@Binds
    @Provides
    @Singleton
    fun provideTrendingMoviesUseCase(MovieRepository: MovieRepository) =
        TrendingMoviesUseCase(MovieRepository)

   //@Binds
    @Provides
    @Singleton
    fun providePopularMoviesUseCase(MovieRepository: MovieRepository) =
        PopularMoviesUseCase(MovieRepository)

   // @Binds
    @Provides
    @Singleton
    fun provideMovieDetailUseCase(MovieRepository: MovieRepository) =
        MovieDetailUseCase(MovieRepository)

}