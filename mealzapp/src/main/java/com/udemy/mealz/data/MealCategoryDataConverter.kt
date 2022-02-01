package com.udemy.mealz.data

import com.udemy.mealz.data.model.MealCategory
import com.udemy.mealz.data.source.remote.entity.NetworkMealCategory

/**
 * Created by Prasada Rao on 01/02/22 4:22 PM
 **/
interface MealCategoryDataConverter {

  fun convertNetworkModelToDomainModel(networkModel: NetworkMealCategory): MealCategory {
    return MealCategory(
      id = networkModel.id,
      category = networkModel.category,
      thumbnailUrl = networkModel.thumbnailUrl,
      description = networkModel.description
    )
  }
}