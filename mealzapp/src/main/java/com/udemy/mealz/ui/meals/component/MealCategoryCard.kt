package com.udemy.mealz.ui.meals.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 02/02/22 1:33 PM
 **/
@Composable
fun MealCategoryCard(
  modifier: Modifier = Modifier,
  mealCategory: MealCategory
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    CircularPhotoCard(
      modifier = Modifier.padding(16.dp),
      mealCategory = mealCategory
    )
    Text(
      text = mealCategory.category,
      style = MaterialTheme.typography.h6
    )
  }
}
