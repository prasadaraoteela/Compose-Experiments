package com.experiments.coreui.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 30/01/22 5:28 PM
 **/
@Composable
fun MyAppBar() {
  TopAppBar(
    navigationIcon = {
      Icon(
        imageVector = Icons.Default.Home,
        contentDescription = null,
        modifier = Modifier.padding(horizontal = 12.dp)
      )
    },
    title = { Text(text = "Users") },
  )
}