package skydu.android.session.second.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import skydu.android.session.second.fragment.FragmentContoh

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 10

    override fun createFragment(position: Int): Fragment {
        return if (position == 1) {
            RecipeFragment()
        } else {
            FragmentContoh()
        }
    }
}