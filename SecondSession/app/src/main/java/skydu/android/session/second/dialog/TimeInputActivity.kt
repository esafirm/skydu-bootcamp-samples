package skydu.android.session.second.dialog

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import skydu.android.session.second.databinding.ActivityTimeInputBinding

class TimeInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTimeInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timePickerListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            binding.inpTime.text = "$hour:$minute"
        }

        binding.btnSetTime.setOnClickListener {
            showTimeDialog(timePickerListener)
        }
    }

    private fun showTimeDialog(
        listener: TimePickerDialog.OnTimeSetListener
    ) {
        val dialog = TimePickerDialog(this, listener, 12, 0, true)
        dialog.show()
    }
}