package com.experiments.compose.data.model

import android.location.Location
import com.google.gson.annotations.SerializedName

/**
 * Created by Prasada Rao on 26/11/21 1:58 PM
 **/
data class Atm(
  @SerializedName("id")
  val id: String,

  @SerializedName("name")
  val name: String,

  @SerializedName("address")
  val address: String,

  @SerializedName("location")
  val location: Location
) {

  data class Location(
    @SerializedName("lat")
    val latitude: Double,

    @SerializedName("lng")
    val longitude: Double,
  )
}
