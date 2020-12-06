package skydu.android.birthdayapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import skydu.android.birthdayapp.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCek.setOnClickListener {
            val name = binding.inpName.text.toString()
            val intent = Intent(this, BirthDayActivity::class.java).apply {
                putExtra("name", name)
            }
            startActivity(intent)
        }
    }
}