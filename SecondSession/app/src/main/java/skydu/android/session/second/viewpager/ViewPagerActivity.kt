package skydu.android.session.second.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import skydu.android.session.second.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(this)
    }
}