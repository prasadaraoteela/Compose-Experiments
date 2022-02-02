package com.udemy.mealz.ui.meals.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 01/02/22 5:48 PM
 **/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MealCategoryList(
  mealCategories: List<MealCategory>
) {
  LazyVerticalGrid(cells = GridCells.Fixed(count = 2)) {
    items(mealCategories) { mealCategory ->
      MealCategoryCard(mealCategory = mealCategory)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MealCategoryListPreview() {
  MealCategoryList(listOf(MealCategory(id = "1", category = "Category", thumbnailUrl = "", description = "")))
}
