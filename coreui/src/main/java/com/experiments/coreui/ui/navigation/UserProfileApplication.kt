package com.experiments.coreui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.experiments.coreui.model.User
import com.experiments.coreui.ui.screen.UserListScreen
import com.experiments.coreui.ui.screen.UserProfileDetailsScreen

/**
 * Created by Prasada Rao on 31/01/22 10:45 AM
 **/
@Composable
fun UserProfileApplication(users: List<User>) {
  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = "users_list") {
    composable("users_list") {
      UserListScreen(navController = navController)
    }
    composable(
      route = "user_details/{userId}",
      arguments = listOf(navArgument("userId") { type = NavType.IntType })
    ) { navBackStack ->
      UserProfileDetailsScreen(
        userId = navBackStack.arguments!!.getInt("userId"),
        navController = navController
      )
    }
  }
}