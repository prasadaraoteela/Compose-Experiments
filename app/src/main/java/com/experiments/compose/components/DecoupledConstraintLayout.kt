package com.experiments.compose.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

/**
 * Created by Prasada Rao on 21/11/21 11:53 AM
 **/
@Composable
fun DecoupledConstraintLayout(modifier: Modifier = Modifier) {

    BoxWithConstraints(modifier = modifier) {
        val constraints = if (minWidth < 600.dp) { // portrait
            decoupledConstraints(16.dp)
        } else {
            decoupledConstraints(32.dp)
        }

        ConstraintLayout(
            constraintSet = constraints,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.layoutId("button")
            ) {
                Text(text = "Button")
            }
            Text(
                text = "Text",
                modifier = Modifier.layoutId("text")
            )
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
            centerHorizontallyTo(parent)
        }

        constrain(text) {
            top.linkTo(button.bottom, margin = margin)
            centerHorizontallyTo(button)
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun DecoupledConstraintLayoutPreview() {
    DecoupledConstraintLayout()
}
