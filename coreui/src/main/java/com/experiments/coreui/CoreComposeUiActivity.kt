package com.experiments.coreui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.experiments.coreui.data.repository.DefaultNameRepository
import com.experiments.coreui.data.repository.NameRepository
import com.experiments.coreui.data.source.local.NameLocalDataSource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class CoreComposeUiActivity : ComponentActivity() {

  @Inject lateinit var repository: NameRepository

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MainScreen(repository)
    }
  }
}

@Composable
fun MainScreen(repository: NameRepository) {

  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    GreetingList(repository)
  }
}

@Composable
fun GreetingList(repository: NameRepository) {

  val greetingStateList by repository.observeNames().observeAsState()

  greetingStateList?.forEach { name ->
    Greeting(name = name)
  }

  Button(onClick = {
    repository.addName("New Name ${Random.nextInt(999999)}")
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
  MainScreen(DefaultNameRepository(NameLocalDataSource()))
}
