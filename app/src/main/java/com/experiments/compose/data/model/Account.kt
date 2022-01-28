package com.experiments.compose.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Prasada Rao on 26/11/21 1:06 PM
 **/
data class Account(

  @SerializedName("accountName")
  val accountName: String,

  @SerializedName("accountNumber")
  val accountNumber: String,

  @SerializedName("available")
  val availableAmount: Double,

  @SerializedName("balance")
  val balanceAmount: Double
)
