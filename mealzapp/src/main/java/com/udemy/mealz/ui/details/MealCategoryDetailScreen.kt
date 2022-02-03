package com.udemy.mealz.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
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
    Image(
      painter = rememberImagePainter(
        data = mealCategory!!.thumbnailUrl,
      ),
      contentDescription = mealCategory!!.category,
      modifier = Modifier.fillMaxWidth(),
      contentScale = ContentScale.Crop
    )
    Text(
      text = mealCategory!!.category,
      style = MaterialTheme.typography.h4,
      modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
    )
    Text(
      text = mealCategory!!.description,
      style = MaterialTheme.typography.subtitle1,
      modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
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
