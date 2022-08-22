package williankl.spinnable.core

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput

private const val ZERO_DEGREES = 0F
private const val NINETY_DEGREES = 90F
private const val ONE_EIGHTY_DEGREES = 180F
private const val THREE_SIXTY_DEGREES = 360F
private const val MILLIS_UNIT = 1000L
@Composable
@ExperimentalComposeUiApi
public fun SpinnableView(
    front: @Composable () -> Unit,
    back: @Composable () -> Unit,
    state: SpinnableState = SpinnableState.Manual.Both,
    modifier: Modifier = Modifier
) {
    val yRotation = remember { mutableStateOf(ZERO_DEGREES) }
    val xRotation = remember { mutableStateOf(ZERO_DEGREES) }

    val isXFrontFacing = remember { mutableStateOf(true) }
    val isYFrontFacing = remember { mutableStateOf(true) }
    val isShowingFront = (isXFrontFacing.value && isYFrontFacing.value) ||
        (isXFrontFacing.value.not() && isYFrontFacing.value.not())

    fun updateRotationState() {
        val paddedX = yRotation.value + NINETY_DEGREES
        val moddedX = paddedX % THREE_SIXTY_DEGREES

        val paddedY = xRotation.value + NINETY_DEGREES
        val moddedY = paddedY % THREE_SIXTY_DEGREES

        isXFrontFacing.value =
            (moddedX in ZERO_DEGREES..ONE_EIGHTY_DEGREES) ||
            (moddedX < -ONE_EIGHTY_DEGREES)

        isYFrontFacing.value =
            (moddedY in ZERO_DEGREES..ONE_EIGHTY_DEGREES) ||
            (moddedY < -ONE_EIGHTY_DEGREES)
    }

    @Composable
    fun rotatingAnimation(speed: Float): Animatable<Float, AnimationVector1D> {
        val duration = remember { (THREE_SIXTY_DEGREES / speed) * MILLIS_UNIT }
        val rotation = remember { Animatable(ZERO_DEGREES) }
        LaunchedEffect(Unit) {
            rotation.animateTo(
                targetValue = THREE_SIXTY_DEGREES,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = duration.toInt(),
                        easing = LinearEasing
                    )
                )
            )
        }

        return rotation
    }

    if (state is SpinnableState.Automatic) {
        val verticalAnimation = rotatingAnimation(state.verticalSpeed)
        xRotation.value = verticalAnimation.value

        val horizontalAnimation = rotatingAnimation(state.horizontalSpeed)
        yRotation.value = horizontalAnimation.value

        updateRotationState()
    }

    Box(
        modifier
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()

                    if (state is SpinnableState.Manual.Both || state is SpinnableState.Manual.Horizontal) {
                        yRotation.value = yRotation.value - dragAmount.x
                    }

                    if (state is SpinnableState.Manual.Both || state is SpinnableState.Manual.Vertical) {
                        xRotation.value = xRotation.value + dragAmount.y
                    }

                    updateRotationState()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .graphicsLayer {
                    rotationY = yRotation.value
                    rotationX = xRotation.value
                }
        ) {
            if (isShowingFront) {
                front()
            } else {
                Box(Modifier.graphicsLayer { rotationY = ONE_EIGHTY_DEGREES }) {
                    back()
                }
            }
        }
    }
}
