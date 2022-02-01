package com.udemy.mealz.data

import com.library.core.data.Result
import com.udemy.mealz.data.model.MealCategory
import com.udemy.mealz.data.source.MealDataSource

/**
 * Created by Prasada Rao on 01/02/22 4:31 PM
 **/
class DefaultMealRepository(
  private val remote: MealDataSource
) : MealRepository {
  override suspend fun fetchMealCategories(): Result<List<MealCategory>> {
    return remote.fetchMealCategories()
  }
}