package com.experiments.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope

/**
 * Created by Prasada Rao on 21/11/21 11:13 AM
 **/
@ExperimentalComposeUiApi
@Composable
fun ConstraintLayoutContent(modifier: Modifier = Modifier) {

    // Create references for the composables to constrain

    ConstraintLayout {
        val (button1, button2, text) = createRefs()
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text(text = "Button 1")
        }
        Text(text = "Some Large Text",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button1.bottom, margin = 16.dp)
                centerAround(button1.end)
            })

        val barrier = createEndBarrier(button1, text)

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(button1.top)
                start.linkTo(barrier)
            }
        ) {
            Text(text = "Button 2")
        }
    }

}

@ExperimentalComposeUiApi
@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun ConstraintLayoutContentPreview() {
    ConstraintLayoutContent()
}
