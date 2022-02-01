package com.technobabble.retrofit.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Prasada Rao on 31/01/22 6:20 PM
 **/
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

  @Singleton
  @Provides
  fun provideRetrofit(httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .client(httpClient)
    .addConverterFactory(GsonConverterFactory.create(Gson()))
    .build()

  @Provides
  fun provideOkHttpClient(): OkHttpClient {
    val httpClientBuilder = OkHttpClient.Builder()
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    httpClientBuilder.addInterceptor(httpLoggingInterceptor)
    return httpClientBuilder.build()
  }
}