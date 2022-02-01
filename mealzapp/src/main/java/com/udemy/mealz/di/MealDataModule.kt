package com.udemy.mealz.di

import android.content.Context
import com.udemy.mealz.data.DefaultMealRepository
import com.udemy.mealz.data.MealRepository
import com.udemy.mealz.data.source.MealDataSource
import com.udemy.mealz.data.source.remote.MealApiService
import com.udemy.mealz.data.source.remote.MealRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit

/**
 * Created by Prasada Rao on 31/01/22 6:52 PM
 **/
@Module
@InstallIn(ActivityComponent::class)
object MealDataModule {

  @Provides
  fun provideMealApi(retrofit: Retrofit): MealApiService {
    return retrofit.create(MealApiService::class.java)
  }

  @Provides
  fun provideRemoteMealDataSource(
    @ApplicationContext applicationContext: Context,
    api: MealApiService
  ): MealDataSource {
    return MealRemoteDataSource(applicationContext, api)
  }

  @Provides
  fun provideMealRepository(
    remote: MealDataSource
  ): MealRepository {
    return DefaultMealRepository(remote = remote)
  }
}