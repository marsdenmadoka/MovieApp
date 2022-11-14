package com.madoka.network.util

import com.madoka.commons.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response




abstract class SafeApiRequest {

    suspend fun <T : Any> safeApiRequest(
        call: suspend () -> Response<T>): T {

        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val responseErr = response.errorBody()?.string()
            val message = StringBuilder()
            responseErr.let {
                try {
                    message.append(JSONObject(it).getString("status_message"))
                } catch (e: JSONException) {
                }
            }
            throw ApiException(message.toString())
        }
    }

}





//suspend fun <T> safeApiCall(
//    apiCall: suspend () -> T
//): Resource<T> {
//
//    return  withContext(Dispatchers.IO){
//        try {
//            Resource.Success(apiCall.invoke())
//        }catch (throwable: Throwable){
//            when(throwable){
//                is HttpException -> {
//                    Resource.Error(
//                        throwable.message()
//                    )
//                }else -> {
//                Resource.Error("unexpected error occurred!")
//            }
//            }
//        }
//    }
//}
