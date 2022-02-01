package com.udemy.mealz.data.source.remote.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Prasada Rao on 31/01/22 6:44 PM
 **/
data class MealCategoryResponse(
  @SerializedName("categories")
  val categories: List<NetworkMealCategory>
)
