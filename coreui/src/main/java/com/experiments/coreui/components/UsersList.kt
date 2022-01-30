package com.experiments.coreui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.coreui.R
import com.experiments.coreui.model.User

/**
 * Created by Prasada Rao on 30/01/22 11:25 AM
 **/

val users = listOf(
  User(name = "Adam", profilePicture = R.drawable.profile_picture_1),
  User(name = "Eve", profilePicture = R.drawable.profile_picture_2),
  User(name = "Adam", profilePicture = R.drawable.profile_picture_1),
  User(name = "Eve", activeState = User.ActiveState.Offline, profilePicture = R.drawable.profile_picture_2),
  User(name = "Adam", activeState = User.ActiveState.Offline, profilePicture = R.drawable.profile_picture_1),
  User(name = "Eve", activeState = User.ActiveState.Offline, profilePicture = R.drawable.profile_picture_2),
)

@Composable
fun UsersList(
  modifier: Modifier = Modifier,
) {
  LazyColumn(modifier = modifier) {
    items(users) { user ->
      ProfileCard(
        user = user,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun UsersListPreview() {
  UsersList()
}
