package williankl.spinnable.sampleAndroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import williankl.spinnable.sampleAndroid.databinding.SampleLayoutBinding

internal class SampleActivity : AppCompatActivity() {

    private val binding by lazy {
        SampleLayoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.spinnableXml.setContent(
            frontFactory = {
                val view = SampleView(it)
                view.setFront()
                view
            },
            backFactory = {
                val view = SampleView(it)
                view.setBack()
                view
            }
        )
    }
}
