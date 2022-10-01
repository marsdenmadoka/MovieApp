package com.madoka.data.di

import com.madoka.commons.BASE_URL
import com.madoka.commons.BuildConfig
import com.madoka.commons.KEY
import com.madoka.data.remote.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private val loggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun ProvidesOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(apiInterceptor)
            .addInterceptor(loggingInterceptor)
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) okHttpClient.addInterceptor(loggingInterceptor)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    //here we passing the our api key to all our routes
    fun ProvidesApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)
    private val apiInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
        val orignialHttpUrl = chain.request().url
        val url = orignialHttpUrl.newBuilder()
            .addQueryParameter(KEY.first, KEY.second)
            .build()
        request.url(url)
        chain.proceed(request.build())
    }

}
