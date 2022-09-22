package com.experiments.compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

/**
 * Created by Prasada Rao on 28/03/22 9:34 AM
 **/
@Preview
@Composable
fun ComposableAsSourceOfTruth() {
  val scaffoldState = rememberScaffoldState()
  val coroutineScope = rememberCoroutineScope()

  Scaffold(scaffoldState = scaffoldState) { paddingValues ->
    Box(modifier = Modifier.padding(paddingValues)) {
      MyContent(
        showSnackBar = { message ->
          coroutineScope.launch {
            scaffoldState.snackbarHostState.showSnackbar(message = message)
          }
        }
      )
    }
  }
}

@Composable
fun MyContent(showSnackBar: (String) -> Unit) {
  Button(onClick = { showSnackBar("Dummy snack bar") }) {
    Text(text = "Show snack bar!")
  }
}