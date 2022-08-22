package williankl.spinnable.core

public sealed class SpinnableState {
    object None : SpinnableState()

    sealed class Manual : SpinnableState() {
        object Horizontal : Manual()
        object Vertical : Manual()
        object Both : Manual()
    }

    data class Automatic(
        val verticalSpeed: Float = 0F,
        val horizontalSpeed: Float = 0F
    ) : SpinnableState()
}
