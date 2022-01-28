package com.experiments.coreui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.experiments.coreui.R

val fonts = FontFamily(
  Font(resId = R.font.roboto_mono_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
  Font(resId = R.font.roboto_mono_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
  Font(resId = R.font.roboto_mono_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
  Font(resId = R.font.roboto_mono_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
  Font(resId = R.font.roboto_mono_semi_bold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
  Font(resId = R.font.roboto_mono_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
  Font(resId = R.font.roboto_mono_light, weight = FontWeight.Light, style = FontStyle.Normal),
  Font(resId = R.font.roboto_mono_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
  Font(resId = R.font.roboto_mono_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
  Font(resId = R.font.roboto_mono_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
  Font(resId = R.font.roboto_mono_extra_light, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
  Font(resId = R.font.roboto_mono_extra_light_italic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
  Font(resId = R.font.roboto_mono_thin, weight = FontWeight.Thin, style = FontStyle.Normal),
  Font(resId = R.font.roboto_mono_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
  h1 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Light,
    fontSize = 96.sp,
    letterSpacing = (-1.5).sp
  ),
  h2 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Light,
    fontSize = 60.sp,
    letterSpacing = (-0.5).sp
  ),
  h3 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 48.sp,
    letterSpacing = 0.sp
  ),
  h4 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 34.sp,
    letterSpacing = 0.25.sp
  ),
  h5 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 24.sp,
    letterSpacing = 0.sp
  ),
  h6 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    letterSpacing = 0.15.sp
  ),
  subtitle1 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    letterSpacing = 0.15.sp
  ),
  subtitle2 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    letterSpacing = 0.1.sp
  ),
  body1 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    letterSpacing = 0.5.sp
  ),
  body2 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.25.sp
  ),
  button = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    letterSpacing = 1.25.sp
  ),
  caption = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    letterSpacing = 0.4.sp
  ),
  overline = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    letterSpacing = 1.5.sp
  )
)