package com.madoka.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.madoka.cache.converters.MovieEntityConverter
import com.madoka.cache.daos.MoviesDao
import com.madoka.cache.models.MovieEntity


@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    MovieEntityConverter::class
)
abstract class AppDatabase:RoomDatabase(){
    abstract fun MoviesDao(): MoviesDao
}


