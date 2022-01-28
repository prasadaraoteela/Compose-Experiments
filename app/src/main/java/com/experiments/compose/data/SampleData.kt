package com.experiments.compose.data

import android.content.Context
import com.experiments.compose.data.model.*
import com.experiments.compose.util.dateToDisplayFormat
import com.experiments.compose.util.numberOfDaysAgo
import com.experiments.compose.util.parse
import com.experiments.compose.util.readJsonAsset

/**
 * Created by Prasada Rao on 13/11/21 12:45 PM
 **/
object SampleData {

  // Sample conversation data
  val conversationSample = listOf(
    Message(
      "Colleague",
      "Test...Test...Test..."
    ),
    Message(
      "Colleague",
      "List of Android versions:\n" +
          "Android KitKat (API 19)\n" +
          "Android Lollipop (API 21)\n" +
          "Android Marshmallow (API 23)\n" +
          "Android Nougat (API 24)\n" +
          "Android Oreo (API 26)\n" +
          "Android Pie (API 28)\n" +
          "Android 10 (API 29)\n" +
          "Android 11 (API 30)\n" +
          "Android 12 (API 31)\n"
    ),
    Message(
      "Colleague",
      "I think Kotlin is my favorite programming language.\n" +
          "It's so much fun!"
    ),
    Message(
      "Colleague",
      "Searching for alternatives to XML layouts..."
    ),
    Message(
      "Colleague",
      "Hey, take a look at Jetpack Compose, it's great!\n" +
          "It's the Android's modern toolkit for building native UI." +
          "It simplifies and accelerates UI development on Android." +
          "Less code, powerful tools, and intuitive Kotlin APIs :)"
    ),
    Message(
      "Colleague",
      "It's available from API 21+ :)"
    ),
    Message(
      "Colleague",
      "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
    ),
    Message(
      "Colleague",
      "Android Studio next version's name is Arctic Fox"
    ),
    Message(
      "Colleague",
      "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
    ),
    Message(
      "Colleague",
      "I didn't know you can now run the emulator directly from Android Studio"
    ),
    Message(
      "Colleague",
      "Compose Previews are great to check quickly how a composable layout looks like"
    ),
    Message(
      "Colleague",
      "Previews are also interactive after enabling the experimental setting"
    ),
    Message(
      "Colleague",
      "Have you tried writing build.gradle with KTS?"
    ),
  )

  val transactionGroup = TransactionGroup(
    transactions = listOf(
      Transaction(
        id = "1506aeeb8c3a699b1e3c87db03156428",
        effectiveDate = "20/07/2017",
        description = "Wdl ATM CBA ATM CIRCULAR QUAY STATION NSW 221092 AUS",
        amount = -200.00
      ),
      Transaction(
        id = "1506aeeb8c3a699b1e3c87db03156428",
        effectiveDate = "20/07/2017",
        description = "Wdl ATM CBA ATM CIRCULAR QUAY STATION NSW 221092 AUS",
        amount = -200.00
      )
    ),
    date = "20/07/2017",
    timeAgo = "3 days ago"
  )

  val transactionGroups = listOf(
    transactionGroup,
    transactionGroup,
  )

  val accountInformation = Account(
    accountName = "Complete Access",
    accountNumber = "062005 1709 5888",
    availableAmount = 226.76,
    balanceAmount = 246.76
  )

  fun parseFromAssets(context: Context): AccountDetail {
    return context.readJsonAsset("exercise.json").parse()
  }

  fun AccountDetail.toTransactionGroups(): List<TransactionGroup> {
    return transactions
      .groupBy { transaction -> transaction.effectiveDate }
      .map { map ->
        TransactionGroup(
          transactions = map.value,
          date = map.key.dateToDisplayFormat(),
          timeAgo = map.key.numberOfDaysAgo()
        )
      }
  }
}