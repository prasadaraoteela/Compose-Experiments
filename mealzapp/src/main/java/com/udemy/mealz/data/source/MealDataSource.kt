package com.udemy.mealz.data.source

import com.library.core.data.Result
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 31/01/22 6:43 PM
 **/
interface MealDataSource {

  suspend fun fetchMealCategories(): Result<List<MealCategory>>

  suspend fun saveMealCategories(mealCategories: List<MealCategory>)

  suspend fun findMealCategoryById(mealCategoryId: String): MealCategory
}