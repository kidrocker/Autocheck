package ke.kiura.autocheck.ui.detail.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ke.kiura.autocheck.core.DefaultConfig.PARAM_DETAIL
import ke.kiura.autocheck.data.models.detail.Detail
import ke.kiura.autocheck.ui.detail.tabs.media.CarMediaFragment


class PagerAdapter(fragment: Fragment, private val detail: Detail) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            1 -> {
                val fragment = CarMediaFragment()
                fragment.arguments = Bundle().apply {

                    putSerializable(PARAM_DETAIL, detail)
                }
                return fragment
            }
            else -> {
                val fragment = CarInfoFragment()
                fragment.arguments = Bundle().apply {

                    putSerializable(PARAM_DETAIL, detail)
                }
                fragment
            }
        }
    }
}