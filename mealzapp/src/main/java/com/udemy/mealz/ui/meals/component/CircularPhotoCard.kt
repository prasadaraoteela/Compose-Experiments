package com.udemy.mealz.ui.meals.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 02/02/22 1:34 PM
 **/
@Composable
fun CircularPhotoCard(modifier: Modifier = Modifier, mealCategory: MealCategory) {
  Card(shape = CircleShape, modifier = modifier) {
    Image(
      painter = rememberImagePainter(
        data = mealCategory.thumbnailUrl,
        builder = {
          crossfade(true)
          transformations(CircleCropTransformation())
        }
      ),
      contentDescription = mealCategory.category,
      modifier = Modifier.requiredSize(192.dp)
    )
  }
}
