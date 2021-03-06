package com.experiments.coreui.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.Transformation
import com.experiments.coreui.R
import com.experiments.coreui.model.User
import com.experiments.coreui.ui.theme.MyTheme
import com.experiments.coreui.ui.theme.lightGreen
import com.experiments.coreui.ui.theme.red

/**
 * Created by Prasada Rao on 29/01/22 11:37 AM
 **/
@Composable
fun ProfileCard(
  modifier: Modifier = Modifier,
  user: User,
  onProfileCardClicked: () -> Unit = {}
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight(align = Alignment.Top)
      .clickable { onProfileCardClicked() },
    elevation = 8.dp,
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      CircularProfilePicture(user = user)
      ProfileContent(user = user)
    }
  }
}

@Composable
fun CircularProfilePicture(user: User) {
  Card(
    shape = CircleShape,
    border = BorderStroke(
      2.dp,
      if (user.activeState == User.ActiveState.Online) {
        MaterialTheme.colors.lightGreen
      } else {
        MaterialTheme.colors.red
      }
    ),
    modifier = Modifier.padding(8.dp)
  ) {
    ProfilePicture(
      user = user,
      modifier = Modifier.size(72.dp),
      transformation = CircleCropTransformation()
    )
  }
}

@Composable
fun ProfilePicture(
  user: User,
  modifier: Modifier = Modifier,
  transformation: Transformation? = null
) {
  Image(
    painter = rememberImagePainter(
      data = user.imageUrl,
      builder = {
        crossfade(true)
        placeholder(R.drawable.profile_picture_1)
        transformation?.let {
          transformations(it)
        }
      }
    ),
    contentDescription = null,
    modifier = modifier,
    contentScale = ContentScale.Crop
  )
}

@Composable
fun ProfileContent(user: User) {
  Column(
    modifier = Modifier
      .padding(8.dp)
      .fillMaxWidth()
  ) {
    CompositionLocalProvider(
      LocalContentAlpha provides if (user.activeState == User.ActiveState.Online) {
        ContentAlpha.high
      } else {
        ContentAlpha.medium
      }
    ) {
      Text(
        text = user.name,
        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
      )
    }
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
      Text(
        text = if (user.activeState == User.ActiveState.Online) {
          "Active Now"
        } else {
          "Offline"
        },
        style = MaterialTheme.typography.body2,
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
  MyTheme {
    ProfileCard(user = users[0])
  }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardDarkPreview() {
  MyTheme(darkTheme = true) {
    ProfileCard(user = users[0])
  }
}
