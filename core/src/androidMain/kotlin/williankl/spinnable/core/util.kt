package williankl.spinnable.core

import android.content.res.TypedArray
import williankl.spinnable.R

private const val None = 0
private const val Manual = 1
private const val Automatic = 2

private const val DefaultSpeed = 360F
private const val NoneSpeed = 0F

internal fun TypedArray.buildSpinnableAttr(): SpinnableState {
    val stateIndex = getInt(R.styleable.SpinnableAttrs_state, Manual)
    val isHorizontalEnabled = getBoolean(R.styleable.SpinnableAttrs_isHorizontalEnabled, true)
    val isVerticalEnabled = getBoolean(R.styleable.SpinnableAttrs_isVerticalEnabled, true)

    val horizontalSpeed = getFloat(R.styleable.SpinnableAttrs_horizontalSpeed, DefaultSpeed)
    val verticalSpeed = getFloat(R.styleable.SpinnableAttrs_verticalSpeed, DefaultSpeed)

    return when (stateIndex) {
        Automatic -> SpinnableState.Automatic(
            verticalSpeed = if (isVerticalEnabled) verticalSpeed else NoneSpeed,
            horizontalSpeed = if (isHorizontalEnabled) horizontalSpeed else NoneSpeed
        )
        Manual -> when {
            isHorizontalEnabled && isVerticalEnabled -> SpinnableState.Manual.Both
            isHorizontalEnabled -> SpinnableState.Manual.Horizontal
            isVerticalEnabled -> SpinnableState.Manual.Vertical
            else -> SpinnableState.None
        }
        else -> SpinnableState.None
    }
}
