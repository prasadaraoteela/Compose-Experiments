package com.experiments.coreui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 29/01/22 3:13 PM
 **/
var outsideStatic = 0
var centerStatic = 0
var insideStatic = 0

var outsideDynamic = 0
var centerDynamic = 0
var insideDynamic = 0

@Composable
fun CompositionLocalProviderSample(modifier: Modifier = Modifier) {
  var color by remember { mutableStateOf(Color.Red) }

  Column {
    Text(text = "staticCompositionLocalOf")
    CompositionLocalProvider(ColorComposableLocalStatic provides color) {
      outsideStatic++
      MyBox(color = Color.Yellow, outside = outsideStatic, center = centerStatic, inside = insideStatic) {
        centerStatic++
        MyBox(color = ColorComposableLocalStatic.current, outsideStatic, centerStatic, insideStatic) {
          insideStatic++
          MyBox(color = Color.Yellow, outsideStatic, centerStatic, insideStatic) {
          }
        }
      }
    }
    Text("compositionLocalOf")
    CompositionLocalProvider(ColorComposableLocalDynamic provides color) {
      outsideDynamic++
      MyBox(color = Color.Yellow, outsideDynamic, centerDynamic, insideDynamic) {
        centerDynamic++
        MyBox(color = ColorComposableLocalDynamic.current, outsideDynamic, centerDynamic, insideDynamic) {
          insideDynamic++
          MyBox(color = Color.Yellow, outsideDynamic, centerDynamic, insideDynamic) {
          }
        }
      }
    }

    Button(
      onClick = {
        color = if (color == Color.Green) {
          Color.Red
        } else {
          Color.Green
        }
      },
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(text = "Click me")
    }
  }
}

@Composable
fun MyBox(
  color: Color,
  outside: Int,
  center: Int,
  inside: Int,
  content: @Composable BoxScope.() -> Unit
) {
  Column(modifier = Modifier.background(color = color)) {
    GreetingMessage(name = "Compose $outside $center $inside")
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      content = content
    )
  }

}

@Composable
fun GreetingMessage(name: String) {
  Text(text = "Hello $name!")
}

val ColorComposableLocalStatic = staticCompositionLocalOf<Color> {
  error("No color provided!")
}

val ColorComposableLocalDynamic = compositionLocalOf<Color> {
  error("No color provided!")
}

@Preview(showBackground = true)
@Composable
fun CompositionLocalProviderSamplePreview() {
  CompositionLocalProviderSample()
}
