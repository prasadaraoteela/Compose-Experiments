package com.udemy.mealz.ui.meals.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 02/02/22 1:33 PM
 **/
@Composable
fun MealCategoryCard(
  modifier: Modifier = Modifier,
  mealCategory: MealCategory
) {

  var isExpanded by remember { mutableStateOf(false) }

  Card(
    shape = RoundedCornerShape(size = 8.dp),
    elevation = 2.dp,
    modifier = modifier
      .fillMaxWidth()
      .padding(top = 16.dp)
  ) {
    Row(modifier = Modifier.animateContentSize()) {
      Image(
        painter = rememberImagePainter(data = mealCategory.thumbnailUrl),
        contentDescription = mealCategory.category,
        modifier = Modifier
          .size(88.dp)
          .padding(8.dp)
          .align(CenterVertically)
      )
      Column(
        modifier = Modifier
          .align(CenterVertically)
          .fillMaxWidth(fraction = 0.8f)
          .padding(16.dp)
      ) {
        Text(
          text = mealCategory.category,
          style = MaterialTheme.typography.h6
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
          Text(
            text = mealCategory.description,
            style = MaterialTheme.typography.subtitle2,
            maxLines = if (isExpanded) Int.MAX_VALUE else 5,
            overflow = TextOverflow.Ellipsis
          )
        }
      }
      Icon(
        imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
        contentDescription = "Expand row",
        modifier = Modifier
          .padding(16.dp)
          .align(CenterVertically)
          .clickable { isExpanded = !isExpanded }
      )
    }
  }
}
