package com.experiments.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import com.experiments.compose.components.*
import com.experiments.compose.data.SampleData.parseFromAssets
import com.experiments.compose.data.SampleData.toTransactionGroups
import com.experiments.compose.ui.theme.ComposeExperimentsTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalFoundationApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      ComposeExperimentsTheme {
        val accountDetail = parseFromAssets(this)
        AccountDetails(account = accountDetail.account, transactionGroups = accountDetail.toTransactionGroups())
      }
    }
  }

  @Composable
  private fun MyApp() {

    var shouldShowOnboard by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboard) {
      OnboardScreen {
        shouldShowOnboard = false
      }
    } else {
      Greetings(names = List(1000) { "$it" })
    }
  }

  @Preview
  @Composable
  fun PreviewMyApp() {
    MyApp()
  }
}
