package williankl.spinnable.sampleAndroid

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import williankl.spinnable.sampleAndroid.databinding.SampleLayoutBinding

internal class SampleActivity : AppCompatActivity() {

    private val binding = SampleLayoutBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }
}
