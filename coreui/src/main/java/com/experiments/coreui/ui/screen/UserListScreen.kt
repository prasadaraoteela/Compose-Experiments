package com.experiments.coreui.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.experiments.coreui.ui.component.MyAppBar
import com.experiments.coreui.ui.component.UsersList
import com.experiments.coreui.ui.theme.MyTheme

/**
 * Created by Prasada Rao on 30/01/22 5:29 PM
 **/
@Composable
fun UserListScreen(navController: NavHostController? = null) {

  Scaffold(topBar = { MyAppBar() }) {
    Surface(
      modifier = Modifier.fillMaxSize(),
    ) {
      UsersList(navController = navController)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun UserListScreenPreview() {
  MyTheme {
    UserListScreen()
  }
}

@Preview(showBackground = true)
@Composable
fun UserListScreenDarkPreview() {
  MyTheme(darkTheme = true) {
    UserListScreen()
  }
}
