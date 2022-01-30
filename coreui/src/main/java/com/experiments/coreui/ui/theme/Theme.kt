package com.experiments.coreui.ui.theme

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

private val DarkColorPalette = darkColors(
  primary = Purple200,
  primaryVariant = Purple700,
  secondary = Teal200
)

private val LightColorPalette = lightColors(
  primary = Purple500,
  primaryVariant = Purple700,
  secondary = Teal200

  /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
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