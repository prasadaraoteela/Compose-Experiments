package com.experiments.coreui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.coreui.components.UsersList
import com.experiments.coreui.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoreComposeUiActivity : ComponentActivity() {

  private val viewModel: CoreUiViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyTheme {
        MainScreen()
      }
    }
  }
}

@Composable
fun MainScreen() {

  Scaffold(topBar = { MyAppBar() }) {
    Surface(
      modifier = Modifier.fillMaxSize(),
    ) {
      UsersList()
    }
  }
}

@Composable
fun MyAppBar() {
  TopAppBar(
    navigationIcon = {
      Icon(
        imageVector = Icons.Default.Home,
        contentDescription = null,
        modifier = Modifier.padding(horizontal = 12.dp)
      )
    },
    title = { Text(text = "Users") },
  )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
  MyTheme {
    MainScreen()
  }
}

@Preview(showBackground = true)
@Composable
fun MainScreenDarkPreview() {
  MyTheme(darkTheme = true) {
    MainScreen()
  }
}
