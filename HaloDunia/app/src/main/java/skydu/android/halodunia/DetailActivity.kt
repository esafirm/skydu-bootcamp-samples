package skydu.android.halodunia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import skydu.android.halodunia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name") ?: "Nama tidak tersedia"
        binding.txtName.text = name
    }
}