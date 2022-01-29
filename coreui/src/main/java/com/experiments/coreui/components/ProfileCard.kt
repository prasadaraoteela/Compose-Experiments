package com.experiments.coreui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.coreui.R

/**
 * Created by Prasada Rao on 29/01/22 11:37 AM
 **/
@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
  Card(
    modifier = modifier
      .padding(16.dp)
      .fillMaxWidth()
      .wrapContentHeight(align = Alignment.Top),
    elevation = 8.dp,
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      ProfilePicture()
      ProfileContent(name = "Adam")
    }
  }
}

@Composable
fun ProfilePicture() {
  Card(
    shape = CircleShape,
    border = BorderStroke(2.dp, Color.Green),
    modifier = Modifier.padding(8.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.profile_picture_1),
      contentDescription = null,
      modifier = Modifier.size(72.dp),
      contentScale = ContentScale.Crop
    )
  }
}

@Composable
fun ProfileContent(name: String) {
  Column(
    modifier = Modifier
      .padding(8.dp)
      .fillMaxWidth()
  ) {
    Text(
      text = name,
      style = MaterialTheme.typography.h5
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
      Text(
        text = "Active Now",
        style = MaterialTheme.typography.body2,
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
  ProfileCard()
}
