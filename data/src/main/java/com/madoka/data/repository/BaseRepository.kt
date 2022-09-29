package com.madoka.data.repository

import com.madoka.commons.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

open class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): com.madoka.commons.Resource<T> {

        return  withContext(Dispatchers.IO){
            try {
                com.madoka.commons.Resource.Success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        com.madoka.commons.Resource.Error(
                            throwable.message()
                        )
                    }else -> {
                    com.madoka.commons.Resource.Error(null)
                }
                }
            }
        }
    }
}
