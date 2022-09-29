package com.madoka.data.di
import com.madoka.data.repository.NowPlayingMovieRepositoryImpl
import com.madoka.domain.repository.NowPlayingMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providesRepository(repositoryImpl: NowPlayingMovieRepositoryImpl): NowPlayingMovieRepository


}


