package williankl.spinnable.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import williankl.spinnable.core.SpinnableState
import williankl.spinnable.core.SpinnableView

public fun main() = application {
    Window(
        title = "Spinnable",
        onCloseRequest = ::exitApplication
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SampleSpinnableScreen(
                label = "No rotation",
                state = SpinnableState.None
            )

            SampleSpinnableScreen(
                label = "Rotated by the user in both ways",
                state = SpinnableState.Manual.Both
            )

            SampleSpinnableScreen(
                label = "Rotated by the user vertically",
                state = SpinnableState.Manual.Vertical
            )

            SampleSpinnableScreen(
                label = "Rotated by the user horizontally",
                state = SpinnableState.Manual.Horizontal
            )

            SampleSpinnableScreen(
                label = "Automatic rotation horizontal",
                state = SpinnableState.Automatic(
                    horizontalSpeed = 360F
                )
            )

            SampleSpinnableScreen(
                label = "Automatic rotation vertical",
                state = SpinnableState.Automatic(
                    verticalSpeed = 360F
                )
            )

            SampleSpinnableScreen(
                label = "Automatic rotation both ways",
                state = SpinnableState.Automatic(
                    horizontalSpeed = 360F,
                    verticalSpeed = 180F
                )
            )
        }
    }
}

@Composable
@OptIn(ExperimentalComposeUiApi::class)
private fun SampleSpinnableScreen(
    label: String,
    state: SpinnableState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(label)
        SpinnableView(
            front = { SampleColoredBox(Color.Blue) },
            back = { SampleColoredBox(Color.Red) },
            state = state
        )
    }
}

@Composable
private fun SampleColoredBox(color: Color) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(8.dp)
            )
    ) { /* nothing */ }
}
