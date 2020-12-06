package skydu.android.halodunia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import skydu.android.halodunia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTitle.alpha = 0F
        binding.btnCek.text = "Cek"
        binding.btnCek.setOnClickListener { view ->
            view as Button
            view.text = "Sudah dicek"

            val nameFromInput = binding.inpName.text.toString()
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("name", nameFromInput)
            }
            startActivity(intent)
        }
    }
}