package com.experiments.coreui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.experiments.coreui.ui.screen.UserListScreen
import com.experiments.coreui.ui.screen.UserProfileDetailsScreen

/**
 * Created by Prasada Rao on 31/01/22 10:45 AM
 **/
@Composable
fun UserProfileApplication() {
  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = "users_list") {
    composable("users_list") { 
      UserListScreen(navController = navController)
    }
    composable("user_details") {
      UserProfileDetailsScreen()
    }
  }
}