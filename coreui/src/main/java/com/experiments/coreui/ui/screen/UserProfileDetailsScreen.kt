package com.experiments.coreui.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.experiments.coreui.ui.component.MyAppBar
import com.experiments.coreui.ui.component.ProfileContent
import com.experiments.coreui.ui.component.ProfilePicture
import com.experiments.coreui.ui.component.users

/**
 * Created by Prasada Rao on 30/01/22 5:31 PM
 **/
@Composable
fun UserProfileDetailsScreen(
  userId: Int,
  navController: NavHostController? = null
) {

  val user = users.firstOrNull { user -> user.id == userId } ?: return

  Scaffold(topBar = {
    MyAppBar(
      title = "User Profile Details",
      navigationIcon = Icons.Default.ArrowBack,
      onNavigationIconClicked = { navController?.navigateUp() }
    )
  }) {
    Surface(modifier = Modifier.fillMaxSize()) {
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
      ) {
        ProfilePicture(
          user = user, modifier = Modifier
            .height(height = 256.dp)
            .fillMaxWidth()
        )
        ProfileContent(user = user)
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsScreenPreview() {
  UserProfileDetailsScreen(userId = 1)
}
