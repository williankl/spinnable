package williankl.spinnable.core

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.viewinterop.AndroidView
import williankl.spinnable.databinding.SpinnableLayoutBinding

public class SpinnableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding: SpinnableLayoutBinding =
        SpinnableLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    private val state: MutableState<SpinnableState> =
        mutableStateOf(SpinnableState.Manual.Both)

    public fun changeViewState(newState: SpinnableState) {
        state.value = newState
    }

    @OptIn(ExperimentalComposeUiApi::class)
    public fun <FrontView : View, BackView : View> setContent(
        frontFactory: (Context) -> FrontView,
        backFactory: (Context) -> BackView,
    ) {
        binding.root.setContent {
            SpinnableView(
                state = state.value,
                front = { AndroidView(frontFactory) },
                back = { AndroidView(backFactory) }
            )
        }
    }
}
