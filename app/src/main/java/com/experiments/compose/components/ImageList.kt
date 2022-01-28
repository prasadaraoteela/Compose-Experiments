package com.experiments.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

/**
 * Created by Prasada Rao on 19/11/21 10:59 AM
 **/
@ExperimentalCoilApi
@Composable
fun ImageList(modifier: Modifier = Modifier) {
    val listSize = 100
    // We can save the scrolling position with this state
    val listState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()
    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch { listState.animateScrollToItem(0) }
            }) {
                Text(text = "Scroll to the top")
            }
            Button(onClick = {
                coroutineScope.launch { listState.animateScrollToItem(listSize - 1) }
            }) {
                Text(text = "Scroll to the end")
            }
        }
        LazyColumn(modifier = modifier, state = listState) {
            items(100) { index ->
                ImageListItem(index = index)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ImageListItem(index: Int) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(data = "https://developer.android.com/images/brand/Android_Robot.png"),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item $index", style = MaterialTheme.typography.subtitle1)
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun ImageListPreview() {
    ImageList()
}
