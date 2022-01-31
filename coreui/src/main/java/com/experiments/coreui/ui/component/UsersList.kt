package com.experiments.coreui.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.experiments.coreui.R
import com.experiments.coreui.model.User

/**
 * Created by Prasada Rao on 30/01/22 11:25 AM
 **/

val users = listOf(
  User(
    id = 1,
    name = "James",
    profilePicture = R.drawable.profile_picture_1,
    imageUrl = "https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
  ),
  User(
    id = 2,
    name = "Robert",
    profilePicture = R.drawable.profile_picture_2,
    imageUrl = "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
  ),
  User(
    id = 3,
    name = "John",
    profilePicture = R.drawable.profile_picture_1,
    imageUrl = "https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
  ),
  User(
    id = 4,
    name = "Mary",
    activeState = User.ActiveState.Offline,
    profilePicture = R.drawable.profile_picture_2,
    imageUrl = "https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
  ),
  User(
    id = 5,
    name = "Patricia",
    activeState = User.ActiveState.Offline,
    profilePicture = R.drawable.profile_picture_1,
    imageUrl = "https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
  ),
  User(
    id = 6,
    name = "Jennifer",
    activeState = User.ActiveState.Offline,
    profilePicture = R.drawable.profile_picture_2,
    imageUrl = "https://images.pexels.com/photos/1382731/pexels-photo-1382731.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
  ),
  User(
    id = 7,
    name = "Elizabeth",
    activeState = User.ActiveState.Offline,
    profilePicture = R.drawable.profile_picture_2,
    imageUrl = "https://images.pexels.com/photos/1858175/pexels-photo-1858175.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
  ),
  User(
    id = 8,
    name = "Michael",
    activeState = User.ActiveState.Offline,
    profilePicture = R.drawable.profile_picture_2,
    imageUrl = "https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
  ),
)

@Composable
fun UsersList(
  modifier: Modifier = Modifier,
  navController: NavHostController? = null
) {
  LazyColumn(modifier = modifier) {
    items(users) { user ->
      ProfileCard(
        user = user,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
      ) {
        navController?.navigate(route = "user_details/${user.id}")
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun UsersListPreview() {
  UsersList()
}
