package williankl.spinnable.sampleAndroid

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import williankl.spinnable.core.SpinnableState
import williankl.spinnable.sampleAndroid.databinding.SampleLayoutBinding

internal class SampleActivity : AppCompatActivity() {

    private val binding by lazy {
        SampleLayoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.spinnableNone.apply {
            changeViewState(SpinnableState.None)
            setContent(
                frontFactory = { frontView(it) },
                backFactory = { backView(it) }
            )
        }

        binding.spinnableManualBoth.apply {
            setContent(
                frontFactory = { frontView(it) },
                backFactory = { backView(it) }
            )
        }

        binding.spinnableAutoBoth.apply {
            changeViewState(
                SpinnableState.Automatic(
                    verticalSpeed = 180F,
                    horizontalSpeed = 360F
                )
            )
            setContent(
                frontFactory = { frontView(it) },
                backFactory = { backView(it) }
            )
        }
    }

    private fun frontView(context: Context): View {
        val view = SampleView(context)
        view.setFront()
        return view
    }

    private fun backView(context: Context): View {
        val view = SampleView(context)
        view.setBack()
        return view
    }
}
