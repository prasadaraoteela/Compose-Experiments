package com.udemy.mealz.di

import android.content.Context
import com.library.core.di.Local
import com.library.core.di.Remote
import com.udemy.mealz.data.DefaultMealRepository
import com.udemy.mealz.data.MealRepository
import com.udemy.mealz.data.source.MealDataSource
import com.udemy.mealz.data.source.local.MealLocalDataSource
import com.udemy.mealz.data.source.remote.MealApiService
import com.udemy.mealz.data.source.remote.MealRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Prasada Rao on 31/01/22 6:52 PM
 **/
@Module
@InstallIn(SingletonComponent::class)
object MealDataModule {

  @Singleton
  @Provides
  fun provideMealApi(retrofit: Retrofit): MealApiService {
    return retrofit.create(MealApiService::class.java)
  }

  @Singleton
  @Provides
  @Local
  fun provideLocalMealDataSource(): MealDataSource = MealLocalDataSource()

  @Singleton
  @Provides
  @Remote
  fun provideRemoteMealDataSource(
    @ApplicationContext applicationContext: Context,
    api: MealApiService
  ): MealDataSource {
    return MealRemoteDataSource(applicationContext, api)
  }

  @Singleton
  @Provides
  fun provideMealRepository(
    @Local local: MealDataSource,
    @Remote remote: MealDataSource
  ): MealRepository {
    return DefaultMealRepository(local = local, remote = remote)
  }
}