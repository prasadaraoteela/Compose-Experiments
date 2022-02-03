package com.udemy.mealz.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.udemy.mealz.data.model.MealCategory
import kotlin.math.min

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

  val scrollState = rememberLazyListState()
  val offset = min(1f, 1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex))

  val imageSize by animateDpAsState(targetValue = max(80.dp, 200.dp * offset))


  Column {
    Surface(elevation = 4.dp) {
      Row(modifier = Modifier.fillMaxWidth()) {
        Card(
          modifier = Modifier.padding(16.dp),
          shape = CircleShape,
          border = BorderStroke(width = 2.dp, color = Color.Green)
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
        Column(
          modifier = Modifier.align(Alignment.CenterVertically)
        ) {
          Text(
            text = mealCategory!!.category,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
          )
        }
      }
    }

    LazyColumn(state = scrollState) {
      items(40) { num ->
        Text(
          text = (mealCategory?.category ?: "Empty category") + " " + num,
          style = MaterialTheme.typography.body1,
          modifier = Modifier.padding(8.dp)
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MealCategoryDetailScreenPreview() {
  MealCategoryDetailScreen(mealCategoryId = "1")
}
