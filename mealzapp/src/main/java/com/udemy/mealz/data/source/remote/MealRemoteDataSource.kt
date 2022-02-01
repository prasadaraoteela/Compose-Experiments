package com.udemy.mealz.data.source.remote

import android.content.Context
import com.library.core.data.Result
import com.technobabble.retrofit.RemoteDataSource
import com.udemy.mealz.data.MealCategoryDataConverter
import com.udemy.mealz.data.model.MealCategory
import com.udemy.mealz.data.source.MealDataSource

/**
 * Created by Prasada Rao on 31/01/22 6:53 PM
 **/
class MealRemoteDataSource(
  private val applicationContext: Context,
  private val api: MealApiService
) : MealDataSource, RemoteDataSource, MealCategoryDataConverter {

  override suspend fun fetchMealCategories(): Result<List<MealCategory>> {
    return prepareResult(
      applicationContext = applicationContext,
      api = { api.fetchMealCategories() },
      dataConverter = { response ->
        response.categories.map { networkMealCategory ->
          convertNetworkModelToDomainModel(networkModel = networkMealCategory)
        }
      }
    )
  }
}