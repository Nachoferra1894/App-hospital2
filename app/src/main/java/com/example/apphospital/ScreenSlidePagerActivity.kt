package com.example.apphospital

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.apphospital.Fragments.daily.*
import com.example.apphospital.classes.DatPagerAdapter
import kotlinx.android.synthetic.main.activity_register_details_form.*
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
        val fragsList = listOf(Item1Fragment(), Item2Fragment(), Item3Fragment(),Item4Fragment())

        adapter.fragsListHere.addAll(fragsList)
        pager.adapter = adapter
        pager.setCurrentItem(0)

        addDots(0)

        val pageChangeCallBack = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                addDots(position)
            }
        }

        viewPager.registerOnPageChangeCallback(pageChangeCallBack)

    }

    @SuppressLint("ResourceAsColor")
    private fun addDots(position: Int) {

        val mDots = Array(5) { TextView(this) }
        viewpagerdia_ll_mdots.removeAllViews()

        for (text in mDots){
            text.text = Html.fromHtml("&#8226")
            text.textSize = 35F
            text.setTextColor(resources.getColor(R.color.azul_registro))

            viewpagerdia_ll_mdots.addView(text)
        }

        if(mDots.isNotEmpty()){
            mDots[position].setTextColor(resources.getColor(R.color.orange))
        }

    }
}

