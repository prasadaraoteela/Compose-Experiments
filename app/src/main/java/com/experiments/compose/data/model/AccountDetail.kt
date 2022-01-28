package com.experiments.compose.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Prasada Rao on 26/11/21 1:57 PM
 **/
data class AccountDetail(
  @SerializedName("account")
  val account: Account,

  @SerializedName("transactions")
  val transactions: List<Transaction>,

  @SerializedName("pending")
  val pending: List<Transaction>,

  @SerializedName("atms")
  val atms: List<Atm>
)
