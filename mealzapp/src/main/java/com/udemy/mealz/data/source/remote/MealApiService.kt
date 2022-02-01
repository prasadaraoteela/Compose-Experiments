package com.udemy.mealz.data.source.remote

import com.udemy.mealz.data.source.remote.entity.MealCategoryResponse
import retrofit2.http.GET

/**
 * Created by Prasada Rao on 31/01/22 6:43 PM
 **/
interface MealApiService {

  @GET("categories.php")
  suspend fun fetchMealCategories(): MealCategoryResponse
}