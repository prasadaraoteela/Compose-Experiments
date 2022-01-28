package com.experiments.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

/**
 * Created by Prasada Rao on 21/11/21 12:57 PM
 **/
@Composable
fun LargeConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val text = createRef()

        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(text = "This is a very very very very very very very long text",
            modifier = Modifier.constrainAs(text) {
                linkTo(start = guideline, end = parent.end)
                width = Dimension.preferredWrapContent
            })
    }
}

@Preview(showBackground = true)
@Composable
fun LargeConstraintLayoutPreview() {
    LargeConstraintLayout()
}
