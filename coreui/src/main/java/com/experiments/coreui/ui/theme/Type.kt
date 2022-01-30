package com.experiments.coreui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.experiments.coreui.R

val RobotoMonoFontFamily = FontFamily(
  Font(
    resId = R.font.roboto_mono_regular,
    weight = FontWeight.Normal,
    style = FontStyle.Normal
  ),
  Font(
    resId = R.font.roboto_mono_italic,
    weight = FontWeight.Normal,
    style = FontStyle.Italic
  ),
  Font(
    resId = R.font.roboto_mono_bold,
    weight = FontWeight.Bold,
    style = FontStyle.Normal
  ),
  Font(
    resId = R.font.roboto_mono_bold_italic,
    weight = FontWeight.Bold,
    style = FontStyle.Italic
  ),
  Font(
    resId = R.font.roboto_mono_semi_bold,
    weight = FontWeight.SemiBold,
    style = FontStyle.Normal
  ),
  Font(
    resId = R.font.roboto_mono_semi_bold_italic,
    weight = FontWeight.SemiBold,
    style = FontStyle.Italic
  ),
  Font(
    resId = R.font.roboto_mono_light,
    weight = FontWeight.Light,
    style = FontStyle.Normal
  ),
  Font(
    resId = R.font.roboto_mono_light_italic,
    weight = FontWeight.Light,
    style = FontStyle.Italic
  ),
  Font(
    resId = R.font.roboto_mono_medium,
    weight = FontWeight.Medium,
    style = FontStyle.Normal
  ),
  Font(
    resId = R.font.roboto_mono_medium_italic,
    weight = FontWeight.Medium,
    style = FontStyle.Italic
  ),
  Font(
    resId = R.font.roboto_mono_extra_light,
    weight = FontWeight.ExtraLight,
    style = FontStyle.Normal
  ),
  Font(
    resId = R.font.roboto_mono_extra_light_italic,
    weight = FontWeight.ExtraLight,
    style = FontStyle.Italic
  ),
  Font(
    resId = R.font.roboto_mono_thin,
    weight = FontWeight.Thin,
    style = FontStyle.Normal
  ),
  Font(
    resId = R.font.roboto_mono_thin_italic,
    weight = FontWeight.Thin,
    style = FontStyle.Italic
  ),
)

// Set of Material typography styles to start with
val Typography = Typography(
  defaultFontFamily = RobotoMonoFontFamily
)