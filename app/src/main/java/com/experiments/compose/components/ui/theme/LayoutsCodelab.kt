package com.experiments.compose.components.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlaylistPlay
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.compose.R
import com.experiments.compose.components.StaggeredGridBodyContent

/**
 * Created by Prasada Rao on 16/11/21 12:05 PM
 **/
@Composable
fun LayoutsCodelab() {
  Scaffold(
    topBar = {
      MyTopAppBar()
    },
    bottomBar = {
      BottomNavigationContent()
    }
  ) { innerPadding ->
    StaggeredGridBodyContent(
      modifier = Modifier
        .padding(innerPadding)
        .padding(8.dp)
    )
  }
}

@Composable
private fun MyTopAppBar(modifier: Modifier = Modifier) {
  TopAppBar(
    modifier = modifier,
    title = {
      Text(text = "LayoutsCodelab")
    },
    backgroundColor = Color.White,
    navigationIcon = {
      Icon(
        painter = painterResource(id = R.drawable.icon_welcome_logo),
        contentDescription = "Navigation Icon",
        tint = Color.Unspecified
      )
    },
    actions = {
      IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
      }
    }
  )
}

@Composable
private fun BottomNavigationContent(modifier: Modifier = Modifier) {
  var selectedItem by remember { mutableStateOf(0) }
  val items = listOf("Songs", "Artists", "Playlists")
  val icons = listOf(Icons.Filled.MusicNote, Icons.Filled.Person, Icons.Filled.PlaylistPlay)

  BottomNavigation(modifier = modifier) {
    items.forEachIndexed { index, item ->
      BottomNavigationItem(
        icon = { Icon(imageVector = icons[index], contentDescription = item) },
        label = { Text(text = item) },
        selected = selectedItem == index,
        onClick = { selectedItem = index }
      )
    }
  }
}

@Composable
private fun BodyContent(modifier: Modifier) {
  Column(modifier = modifier) {
    Text(text = "Hi there!")
    Text(text = "Thanks for going through the Layouts codelab")
  }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun LayoutsCodelabPreview() {
  LayoutsCodelab()
}
