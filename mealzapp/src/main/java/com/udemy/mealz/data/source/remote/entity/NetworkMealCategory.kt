package com.udemy.mealz.data.source.remote.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Prasada Rao on 31/01/22 6:44 PM
 **/
data class NetworkMealCategory(
  @SerializedName("idCategory")
  val id: String,

  @SerializedName("strCategory")
  val category: String,

  @SerializedName("strCategoryThumb")
  val thumbnailUrl: String,

  @SerializedName("strCategoryDescription")
  val description: String
)
