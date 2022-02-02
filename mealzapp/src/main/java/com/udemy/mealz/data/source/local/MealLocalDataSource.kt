package com.udemy.mealz.data.source.local

import com.library.core.data.Result
import com.udemy.mealz.data.model.MealCategory
import com.udemy.mealz.data.source.MealDataSource

/**
 * Created by Prasada Rao on 02/02/22 9:20 PM
 **/
class MealLocalDataSource : MealDataSource {

  private var mealCategories: List<MealCategory> = ArrayList()

  override suspend fun fetchMealCategories(): Result<List<MealCategory>> {
    return Result.Success(mealCategories)
  }

  override suspend fun saveMealCategories(mealCategories: List<MealCategory>) {
    this.mealCategories = mealCategories
  }

  override suspend fun findMealCategoryById(mealCategoryId: String): MealCategory {
    return mealCategories.first { mealCategory -> mealCategory.id == mealCategoryId }
  }
}