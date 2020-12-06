package skydu.android.birthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import skydu.android.birthdayapp.databinding.ActivityBirthdayBinding
import java.util.*

class BirthDayActivity : AppCompatActivity() {

    private val data: Map<String, String> = mapOf(
        "ade" to "25 September 1945",
        "arman" to "11 Februari 1984",
        "zamzam" to "1 Januari 200"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBirthdayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data dari [Intent]
        val name = intent.getStringExtra("name") ?: ""

        // Mengambil data ulang tahun dengan key berupa nama yang sudah di format
        // untuk support perbedaan case
        val birthDay = data[name.toLowerCase(Locale.getDefault()).trim()]

        binding.txtName.text = name
        binding.txtDate.text = birthDay
    }
}