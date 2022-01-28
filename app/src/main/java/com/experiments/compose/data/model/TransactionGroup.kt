package com.experiments.compose.data.model

/**
 * Created by Prasada Rao on 26/11/21 1:33 PM
 **/
data class TransactionGroup(
  val transactions: List<Transaction>,
  val date: String,
  val timeAgo: String
)
