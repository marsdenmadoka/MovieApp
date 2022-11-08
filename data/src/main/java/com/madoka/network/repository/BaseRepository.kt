package com.madoka.network.repository

import com.madoka.commons.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

open class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {

        return  withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                      Resource.Error(
                            throwable.message()
                        )
                    }else -> {
               Resource.Error(null)
                }
                }
            }
        }
    }
}
