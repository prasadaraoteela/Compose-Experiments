package com.experiments.compose.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 30/11/21 5:50 PM
 **/
@Composable
fun FlexExperiment(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .height(200.dp)
      .border(width = 1.dp, color = Color.Green),
    verticalArrangement = Arrangement.SpaceAround
  ) {
    Text(text = "Item1", modifier = Modifier.align(Alignment.CenterHorizontally))
    Text(text = "Item2", modifier = Modifier.align(Alignment.CenterHorizontally))
  }
}

@Preview(showBackground = true)
@Composable
fun FlexExperimentPreview() {
  FlexExperiment()
}
