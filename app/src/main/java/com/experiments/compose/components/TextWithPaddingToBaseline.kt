package com.experiments.compose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.experiments.compose.components.ui.theme.ComposeExperimentsTheme

/**
 * Created by Prasada Rao on 20/11/21 11:41 AM
 **/
fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(layout { measurable, constraints ->
    val placeable: Placeable = measurable.measure(constraints = constraints)

    // Check the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)

    val firstBaseline = placeable[FirstBaseline]

    // Height of the composable with padding - first baseline
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        // Where the composable gets placed
        placeable.placeRelative(0, placeableY)
    }
})

@Composable
fun CustomLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        // measure and position children given constraints logic here
        val placebles = measurables.map { measurable -> measurable.measure(constraints) }
        layout(0, 0) {
            placebles.map { placeable ->
                placeable.placeRelative(0, 0)
            }
        }
    }
}

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) { measurables: List<Measurable>, constraints: Constraints ->
        // measure and position children given constraints logic here

        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each child
            measurable.measure(constraints)
        }

        // Track the y co-ord we have placed children up to
        var yPosition = 0

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.map { placeable ->
                placeable.placeRelative(0, yPosition)

                yPosition += placeable.height
            }
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    MyOwnColumn(modifier = modifier.padding(8.dp)) {
        Text("MyOwnColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}

@Preview(showBackground = true)
@Composable
fun BodyContentPreview() {
    BodyContent()
}

@Preview(showBackground = true)
@Composable
fun TextWithPaddingToBaselinePreview() {
    ComposeExperimentsTheme {
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun TextWithNormalPaddingPreview() {
    ComposeExperimentsTheme {
        Text("Hi there!", Modifier.padding(top = 32.dp))
    }
}