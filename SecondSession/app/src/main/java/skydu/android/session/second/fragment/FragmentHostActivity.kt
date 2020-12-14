package skydu.android.session.second.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import skydu.android.session.second.R

class FragmentHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activty_host)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, FragmentContoh())
            .commit()
    }
}