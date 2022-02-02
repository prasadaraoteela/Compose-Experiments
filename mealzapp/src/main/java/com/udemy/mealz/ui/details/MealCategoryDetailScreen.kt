package com.udemy.mealz.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.udemy.mealz.R
import com.udemy.mealz.data.model.MealCategory

/**
 * Created by Prasada Rao on 02/02/22 7:00 PM
 **/
@Composable
fun MealCategoryDetailScreen(mealCategoryId: String) {

  val viewModel: MealDetailViewModel = hiltViewModel()

  val mealCategory: MealCategory? by viewModel.getMealCategoryById(mealCategoryId = mealCategoryId).observeAsState()

  if (mealCategory == null) {
    Text(text = "No meal category found with given id = $mealCategoryId")
    return
  }

  Column {
    Row {
      Card {
        Image(
          painter = rememberImagePainter(
            data = mealCategory!!.thumbnailUrl,
            builder = {
              transformations(CircleCropTransformation())
            }
          ),
          contentDescription = mealCategory!!.category,
          modifier = Modifier.size(200.dp)
        )
      }
      Text(text = mealCategory!!.category)
    }
    Button(onClick = { /*TODO*/ }) {
      Text(text = stringResource(R.string.button_change_meal_state_image))
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MealCategoryDetailScreenPreview() {
  MealCategoryDetailScreen(mealCategoryId = "1")
}
