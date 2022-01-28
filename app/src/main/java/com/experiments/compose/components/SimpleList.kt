package com.experiments.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 19/11/21 10:41 AM
 **/
@Composable
fun SimpleList(modifier: Modifier = Modifier) {

    val scrollState = rememberLazyListState()

    LazyColumn(modifier = modifier.fillMaxWidth(), state = scrollState) {
        items(100) { item ->
            println("Item $item")
            Text("Item $item", modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth())
        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun SimpleListPreview() {
    SimpleList()
}
