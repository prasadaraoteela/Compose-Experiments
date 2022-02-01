package com.udemy.mealz.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 01/02/22 5:48 PM
 **/
@Composable
fun MealCategoryList(
  mealCategories: List<MealCategory>
) {
  LazyColumn {
    items(mealCategories) { mealCategory ->
      Text(text = mealCategory.category)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MealCategoryListPreview() {
  MealCategoryList(listOf(MealCategory(id = "1", category = "Category", thumbnailUrl = "", description = "")))
}
