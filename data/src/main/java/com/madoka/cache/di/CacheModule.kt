package com.madoka.cache.di

import android.app.Application
import androidx.room.Room
import com.madoka.cache.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {



    //injecting our database
    @Provides
    @Singleton //create one instance of our database
    fun provideDatabase(app: Application) : AppDatabase =
        Room.databaseBuilder(app,AppDatabase::class.java,"Movie_Database")
            .fallbackToDestructiveMigration()
            .build()
}