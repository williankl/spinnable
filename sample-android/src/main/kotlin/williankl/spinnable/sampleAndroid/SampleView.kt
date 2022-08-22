package williankl.spinnable.sampleAndroid

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.annotation.ColorRes
import williankl.spinnable.sampleAndroid.databinding.SampleItemLayoutBinding

internal class SampleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val binding: SampleItemLayoutBinding =
        SampleItemLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    fun setFront() {
        applyColor(R.color.frontColor)
    }

    fun setBack() {
        applyColor(R.color.backColor)
    }

    private fun applyColor(@ColorRes res: Int) {
        val context = binding.root.context
        val color = context.getColor(res)
        binding.root.setBackgroundColor(color)
    }
}
