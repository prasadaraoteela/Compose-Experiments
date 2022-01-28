package com.experiments.coreui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.experiments.coreui.ui.theme.ComposeExperimentsTheme

class CoreComposeUiActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {

    }
  }
}

@Composable
fun MainScreen() {
  Surface(
    color = Color.DarkGray,
    modifier = Modifier.fillMaxSize()
  ) {
    Text(
      text = "Wrapped Content",
      modifier = Modifier.wrapContentSize()
    )
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  MainScreen()
}