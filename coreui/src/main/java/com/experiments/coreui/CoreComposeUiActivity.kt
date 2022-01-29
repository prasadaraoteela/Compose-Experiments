package com.experiments.coreui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.experiments.coreui.data.repository.DefaultNameRepository
import com.experiments.coreui.data.source.local.NameLocalDataSource
import com.experiments.coreui.ui.theme.ComposeExperimentsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoreComposeUiActivity : ComponentActivity() {

  private val viewModel: CoreUiViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeExperimentsTheme {
        MainScreen(viewModel)
      }
    }
  }
}

@Composable
fun MainScreen(viewModel: CoreUiViewModel) {

  val names by viewModel.observeNames().observeAsState()

  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    GreetingList(names ?: emptyList()) { name ->
      viewModel.addName(name)
    }
  }
}

@Composable
fun GreetingList(names: List<String>, onNameAdded: (String) -> Unit) {

  names.forEach { name ->
    Greeting(name = name)
  }

  var newName by remember { mutableStateOf("") }

  OutlinedTextField(value = newName, onValueChange = { newName = it })

  Button(onClick = {
    onNameAdded(newName)
    newName = ""
  }) {
    Text(text = "Add new name")
  }
}

@Composable
fun Greeting(name: String) {
  Text(
    text = "Hello, $name!",
    style = MaterialTheme.typography.h3
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingListPreview() {
  ComposeExperimentsTheme {
    MainScreen(CoreUiViewModel(DefaultNameRepository(NameLocalDataSource())))
  }
}
