package com.experiments.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.compose.R

/**
 * Created by Prasada Rao on 29/03/22 12:05 PM
 **/
@Preview
@Composable
fun ImageCard() {
  Card(
    modifier = Modifier
      .size(200.dp),
    shape = RoundedCornerShape(16.dp),
    elevation = 5.dp
  ) {
    Box(modifier = Modifier.height(200.dp)) {
      Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.profile_picture_1),
        contentDescription = null,
        contentScale = ContentScale.Crop
      )

      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(
            brush = Brush.verticalGradient(
              colors = listOf(
                Color.Transparent,
                Color.White
              ),
              startY = 300f
            )
          )
          .padding(12.dp),
        contentAlignment = Alignment.BottomCenter
      ) {
        Text(
          text = "This is a sample profile picture",
          style = TextStyle(color = Color.Black)
        )
      }
    }
  }
}