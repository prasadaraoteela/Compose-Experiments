package com.udemy.mealz.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.library.core.data.Result
import com.udemy.mealz.data.model.MealCategory
import com.udemy.mealz.ui.component.MealCategoryList
import com.udemy.mealz.ui.meals.MealCategoryViewModel

/**
 * Created by Prasada Rao on 01/02/22 5:43 PM
 **/
@Composable
fun MealCategoriesScreen() {
  val viewModel: MealCategoryViewModel = viewModel()

  val mealCategoriesResult: Result<List<MealCategory>>? by viewModel.observeMealCategories().observeAsState()

  if (mealCategoriesResult is Result.Success) {
    MealCategoryList(mealCategories = (mealCategoriesResult as Result.Success?)?.data ?: emptyList())
  } else if (mealCategoriesResult is Result.Failure) {
    Text(text = (mealCategoriesResult as Result.Failure).error.errorMessage)
  }
}

@Preview(showBackground = true)
@Composable
fun MealCategoriesScreenPreview() {
  MealCategoriesScreen()
}
