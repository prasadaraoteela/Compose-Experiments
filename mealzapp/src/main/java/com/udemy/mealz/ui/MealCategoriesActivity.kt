package com.udemy.mealz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.udemy.mealz.ui.screen.MealCategoriesScreen
import com.udemy.mealz.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Prasada Rao on 01/02/22 5:42 PM
 **/
@AndroidEntryPoint
class MealCategoriesActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyTheme {
        MealCategoriesScreen()
      }
    }
  }
}