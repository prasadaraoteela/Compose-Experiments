package com.experiments.coreui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.experiments.coreui.ui.component.users
import com.experiments.coreui.ui.navigation.UserProfileApplication
import com.experiments.coreui.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoreComposeUiActivity : ComponentActivity() {

  private val viewModel: CoreUiViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyTheme {
        UserProfileApplication(users = users)
      }
    }
  }
}