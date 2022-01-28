package com.experiments.compose.data.model

/**
 * Created by Prasada Rao on 26/11/21 1:03 PM
 **/
data class Transaction(
  val id: String,
  val effectiveDate: String,
  val description: String,
  val amount: Double,
  val atmId: String? = null,
  val state: State = State.Cleared,
  val type: Type = Type.Default
) {
  enum class State {
    Pending,
    Cleared
  }

  enum class Type {
    Default,
    ATMWithdrawal
  }
}
