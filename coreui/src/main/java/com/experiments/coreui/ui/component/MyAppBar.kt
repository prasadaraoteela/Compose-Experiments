package com.experiments.coreui.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 30/01/22 5:28 PM
 **/
@Composable
fun MyAppBar(
  title: String,
  navigationIcon: ImageVector = Icons.Default.ArrowBack,
  onNavigationIconClicked: () -> Unit = {}
) {
  TopAppBar(
    navigationIcon = {
      Icon(
        imageVector = navigationIcon,
        contentDescription = null,
        modifier = Modifier.padding(horizontal = 12.dp).clickable {
          onNavigationIconClicked()
        }
      )
    },
    title = { Text(text = title) },
  )
}