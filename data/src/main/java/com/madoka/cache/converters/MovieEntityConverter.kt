package com.madoka.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.madoka.cache.models.MovieEntity

class MovieEntityConverter {
    private val gson = Gson()

    @TypeConverter
    fun from(movieEntity: List<MovieEntity>): String? {
        if (movieEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<MovieEntity>?>() {}.type
        return gson.toJson(movieEntity, type)

    }

    @TypeConverter
    fun to(movieEntityString:String?):List<MovieEntity>?{
        if (movieEntityString.isNullOrEmpty()) return null

        val type = object : TypeToken<List<MovieEntity>?>() {}.type
        return gson.fromJson(movieEntityString, type)
    }
}