package com.example.apphospital

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.apphospital.Fragments.*
import kotlinx.android.synthetic.main.activity_viewpager_diario.*

private const val NUM_PAGES = 6

class ScreenSlidePagerActivity() : FragmentActivity() {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager_diario)

        val adapter = DatPagerAdapter(this)
        val fragsList = listOf(Item1Fragment(), Item2Fragment(), Item3Fragment(), Item4Fragment(), Item5Fragment(), Item6Fragment())

        adapter.fragsListHere.addAll(fragsList)
        pager.adapter = adapter
        pager.setCurrentItem(0)

    }

    class DatPagerAdapter(fragactivity: FragmentActivity) : FragmentStateAdapter(fragactivity) {
        val fragsListHere = mutableListOf<Fragment>()
        override fun getItemCount():Int = fragsListHere.size
        override fun createFragment(position: Int): Fragment = fragsListHere[position]
    }
}
