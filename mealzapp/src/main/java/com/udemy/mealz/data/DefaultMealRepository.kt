package com.udemy.mealz.data

import com.library.core.data.Result
import com.udemy.mealz.data.model.MealCategory
import com.udemy.mealz.data.source.MealDataSource

/**
 * Created by Prasada Rao on 01/02/22 4:31 PM
 **/
class DefaultMealRepository(
  private val local: MealDataSource,
  private val remote: MealDataSource
) : MealRepository {
  override suspend fun fetchMealCategories(): Result<List<MealCategory>> {
    val response: Result<List<MealCategory>> = remote.fetchMealCategories()
    if (response is Result.Success) {
      local.saveMealCategories(response.data)
      return local.fetchMealCategories()
    }
    return response
  }

  override suspend fun findMealCategoryById(mealCategoryId: String): MealCategory {
    return local.findMealCategoryById(mealCategoryId = mealCategoryId)
  }
}