package com.madoka.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.madoka.cache.models.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    /*saving movies from our network to local db/room*/
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMovies(movieEntitities: List<MovieEntity>)

    /*getting movies from our local db NOT A SUSPEND FUNCTION*/
    @Query("SELECT * FROM `Movies Table` WHERE category=:category")
    fun getMovies(category: String): Flow<List<MovieEntity>> //note category  e.g trending movies,now playing movies etc

    @Query("DELETE FROM `Movies Table`")
    suspend fun deleteAllMovies()


}