package com.experiments.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.experiments.compose.components.AccountDetails
import com.experiments.compose.components.Greetings
import com.experiments.compose.components.OnboardScreen
import com.experiments.compose.data.SampleData.parseFromAssets
import com.experiments.compose.data.SampleData.toTransactionGroups
import com.experiments.compose.ui.theme.ComposeExperimentsTheme
import com.udemy.mealz.ui.meals.MealCategoriesActivity

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

    startActivity(Intent(this, MealCategoriesActivity::class.java))
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
