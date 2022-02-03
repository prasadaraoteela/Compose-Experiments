package com.udemy.mealz.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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

  var pictureState by remember { mutableStateOf(MealCategoryPictureState.Normal) }

  val transition = updateTransition(targetState = pictureState, label = mealCategoryId)
  val imageSize: Dp by transition.animateDp(
    targetValueByState = { state -> state.size },
    label = "MealCategoryPictureSizeAnimation"
  )
  val imageBorderWidth: Dp by transition.animateDp(
    targetValueByState = { state -> state.borderWidth },
    label = "MealCategoryPictureBorderWidthAnimation"
  )
  val imageBorderColor: Color by transition.animateColor(
    targetValueByState = { state -> state.color },
    label = "MealCategoryPictureBorderAnimation"
  )

  Column {
    Row {
      Card(
        modifier = Modifier.padding(16.dp),
        shape = CircleShape,
        border = BorderStroke(width = imageBorderWidth, color = imageBorderColor)
      ) {
        Image(
          painter = rememberImagePainter(
            data = mealCategory!!.thumbnailUrl,
          ),
          contentDescription = mealCategory!!.category,
          modifier = Modifier.size(imageSize),
          contentScale = ContentScale.Crop
        )
      }
      Column {
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
      }
    }
    Button(onClick = {
      pictureState = if (pictureState == MealCategoryPictureState.Normal) {
        MealCategoryPictureState.Expanded
      } else {
        MealCategoryPictureState.Normal
      }
    }) {
      Text(text = stringResource(R.string.button_change_meal_state_image))
    }
  }
}

enum class MealCategoryPictureState(
  val color: Color, val size: Dp, val borderWidth: Dp
) {
  Normal(color = Color.Magenta, size = 120.dp, borderWidth = 8.dp),
  Expanded(color = Color.Green, size = 200.dp, borderWidth = 24.dp)
}

@Preview(showBackground = true)
@Composable
fun MealCategoryDetailScreenPreview() {
  MealCategoryDetailScreen(mealCategoryId = "1")
}
