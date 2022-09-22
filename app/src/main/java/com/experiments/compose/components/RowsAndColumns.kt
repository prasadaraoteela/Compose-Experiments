package com.experiments.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 29/03/22 11:21 AM
 **/
@Preview(showBackground = true)
@Composable
fun ColumnSample() {

  Column(
    modifier = Modifier.size(200.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly
  ) {
    Text(
      text = "Hello",
      modifier = Modifier
        .background(Color.Green)
    )
    Text(
      text = "World",
      modifier = Modifier
        .background(Color.Blue)
    )
  }
}