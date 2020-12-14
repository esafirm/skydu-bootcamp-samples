package skydu.android.session.second.recycler

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import skydu.android.session.second.databinding.ActivityKueBinding

class KueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityKueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val listOfKue = listOf("Nastar", "Putri Salju", "Keju", "Oreo", "Poki")

        val adapter = KueAdapter(listOfKue)

        binding.recyclerView.adapter = adapter

        adapter.onItemClick = { position: Int ->
            AlertDialog.Builder(this@KueActivity)
                .setMessage("Ini posisi ke: $position")
                .show()
        }
    }
}