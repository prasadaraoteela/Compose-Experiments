package com.experiments.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Created by Prasada Rao on 28/03/22 5:33 PM
 **/
@Composable
fun DisposableEffectSample(
  lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
  onStart: () -> Unit = {}, // Send the 'started' analytics event
  onStop: () -> Unit = {}, // Send the 'stopped' analytics event
) {
  // Safely update the current lambdas when a new one is provided
  val currentOnStart by rememberUpdatedState(newValue = onStart)
  val currentOnStop by rememberUpdatedState(newValue = onStop)

  // If `lifecycleOwner` changes, dispose and reset the effect
  DisposableEffect(lifecycleOwner) {
    // Create an observer that triggers our remembered callbacks
    // for sending analytics events
    val observer = LifecycleEventObserver { _, event ->
      if (event == Lifecycle.Event.ON_START) {
        currentOnStart()
      } else if (event == Lifecycle.Event.ON_STOP) {
        currentOnStop()
      }
    }

    // Add the observer to the lifecycle
    lifecycleOwner.lifecycle.addObserver(observer)

    // When the effect leaves the Composition, remove the observer
    onDispose {
      lifecycleOwner.lifecycle.removeObserver(observer)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DisposableEffectSamplePreview() {
  DisposableEffectSample()
}
