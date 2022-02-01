package com.udemy.mealz.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val BlueDarkColorPalette = darkColors(
  primary = Blue200,
  primaryVariant = Blue700,
  secondary = Orange200,
  secondaryVariant = Orange700,
  surface = BlueGrey900
)

private val BlueLightColorPalette = lightColors(
  primary = Blue500,
  primaryVariant = Blue700,
  secondary = Orange200,
  secondaryVariant = Orange700,
  surface = Color.White
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
  val colors = if (darkTheme) {
    BlueDarkColorPalette
  } else {
    BlueLightColorPalette
  }

  MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}