package com.udemy.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.udemy.mealz.ui.details.MealCategoryDetailScreen
import com.udemy.mealz.ui.meals.screen.MealCategoriesScreen
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
        MealsApp()
      }
    }
  }

  @Composable
  fun MealsApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "meals_categories_screen") {
      composable("meals_categories_screen") {
        MealCategoriesScreen(onMealCategoryClicked = { mealCategoryId ->
          navController.navigate("meal_category_details_screen/$mealCategoryId")
        })
      }
      composable(
        route = "meal_category_details_screen/{meal_category_id}",
        arguments = listOf(
          navArgument("meal_category_id") {
            NavType.StringType
          }
        )
      ) { navBackStackEntry ->
        MealCategoryDetailScreen(mealCategoryId = navBackStackEntry.arguments!!.getString("meal_category_id", ""))
      }
    }
  }
}