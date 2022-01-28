package com.experiments.compose.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 13/11/21 3:51 PM
 **/
@Composable
fun TopicChip(topic: Topic, selected: Boolean) {
    val radius = animateDpAsState(
        targetValue = if (selected) 20.dp else 0.dp
    )
    Card(shape = RoundedCornerShape(topStart = radius.value)) {
        Row {
            Text(
                text = topic.name,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

data class Topic(val name: String, val image: ImageBitmap)