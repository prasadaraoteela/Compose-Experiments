package com.udemy.mealz.data

import com.library.core.data.Result
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 31/01/22 6:40 PM
 **/
interface MealRepository {

  suspend fun fetchMealCategories(): Result<List<MealCategory>>
}