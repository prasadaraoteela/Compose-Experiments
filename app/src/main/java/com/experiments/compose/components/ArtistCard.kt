package com.experiments.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.compose.R
import kotlinx.coroutines.delay

/**
 * Created by Prasada Rao on 28/03/22 12:05 PM
 **/
@Preview(showBackground = true)
@Composable
fun ArtistCard(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier
      .size(width = 400.dp, height = 100.dp)
      .padding(16.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Image(
      painter = painterResource(id = R.drawable.bio_sisley_alfred),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .fillMaxHeight()
        .clip(CircleShape)
    )
    Column(
      modifier = Modifier
        .padding(start = 16.dp)
        .fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start,
    ) {
      Text(
        text = "Alfred Sisley",
        style = MaterialTheme.typography.h6,
      )
      Text(
        text = "3 minutes ago",
        style = MaterialTheme.typography.subtitle1
      )
    }
  }
}

@Preview
@Composable
fun MatchParentSizeComposable() {
  Box {
    Spacer(
      modifier = Modifier
        .matchParentSize()
        .background(Color.LightGray)
    )
    ArtistCard()
  }
}

const val SplashWaitTimeMillis = 2000L

@Composable
fun LandingScreen(onTimeout: () -> Unit) {
  // This will always refer to the latest onTimeout function that
  // LandingScreen was recomposed with
  val currentOnTimeout by rememberUpdatedState(newValue = onTimeout)

  // Create an effect that matches the lifecycle of LandingScreen.
  // If LandingScreen recomposes, the delay shouldn't start again.
  LaunchedEffect(true) {
    delay(SplashWaitTimeMillis)
    currentOnTimeout()
  }
}