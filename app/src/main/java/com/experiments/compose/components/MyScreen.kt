package com.experiments.compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

/**
 * Created by Prasada Rao on 28/03/22 4:41 PM
 **/
data class UiState<Data>(
  val hasError: Boolean = true,
  val data: Data
)

data class Movie(
  val name: String
)

@Composable
fun MyScreen(
  state: UiState<List<Movie>>,
  scaffoldState: ScaffoldState = rememberScaffoldState()
) {
  // Creates a CoroutineScope bound to the MoviesScreen's lifecycle
  val scope = rememberCoroutineScope()

  // If the UI state contains an error, show snack bar
  if (state.hasError) {
    // `LaunchedEffect` will cancel and re-launch if
    // `scaffoldState.snackbarHostState` changes
    LaunchedEffect(scaffoldState.snackbarHostState) {
      // Show snackbar using a coroutine, when the coroutine is cancelled the
      // snackbar will automatically dismiss. This coroutine will cancel whenever
      // `state.hasError` is false, and only start when `state.hasError` is true
      // (due to the above if-check), or if `scaffoldState.snackbarHostState` changes.
      scaffoldState.snackbarHostState.showSnackbar(
        message = "Error message",
        actionLabel = "Retry"
      )
    }
  }

  Scaffold(scaffoldState = scaffoldState) { paddingValues ->
    Box(modifier = Modifier.padding(paddingValues)) {
      Column {
        Button(onClick = {
          scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(message = "Something happened!")
          }
        }) {
          Text(text = "Press me")
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
  MyScreen(state = UiState(hasError = true, data = emptyList()))
}
