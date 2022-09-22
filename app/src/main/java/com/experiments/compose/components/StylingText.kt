package com.experiments.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.experiments.coreui.ui.theme.LexendFontFamily

/**
 * Created by Prasada Rao on 29/03/22 1:04 PM
 **/
@Preview
@Composable
fun StylingTextSample() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFF101010))
  ) {
    Text(
      text = buildAnnotatedString {
        withStyle(
          style = SpanStyle(
            color = Color.Green,
            fontSize = 50.sp
          )
        ) {
          append("J")
        }
        append("etpack")
      },
      color = Color.White,
      fontSize = 30.sp,
      fontFamily = LexendFontFamily,
      fontWeight = FontWeight.Bold,
      fontStyle = FontStyle.Italic,
      textAlign = TextAlign.Center,
      textDecoration = TextDecoration.Underline
    )
  }
}