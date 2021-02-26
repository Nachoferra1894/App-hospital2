package com.example.apphospital

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.apphospital.Fragments.daily.*
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.classes.DatPagerAdapter
import com.example.apphospital.classes.NoSwipePager
import kotlinx.android.synthetic.main.activity_register_details_form.*
import kotlinx.android.synthetic.main.activity_viewpager_diario.*

private const val NUM_PAGES = 6

class ScreenSlidePagerActivity() : FragmentActivity(), Retriever {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager_diario)
        viewPager = pager

        val adapter = DatPagerAdapter(this)
        val fragsList = listOf(Item1Fragment(this), Item2Fragment(this), Item3Fragment(this),Item4Fragment(this),Item5Fragment(this),Item6Fragment(this))

        adapter.fragsListHere.addAll(fragsList)
        pager.adapter = adapter
        pager.setCurrentItem(0)

        addDots(0,fragsList.size)

        val pageChangeCallBack = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                addDots(position,fragsList.size)
            }
        }

        viewPager.registerOnPageChangeCallback(pageChangeCallBack)

    }

    @SuppressLint("ResourceAsColor")
    private fun addDots(position: Int,size: Int) {

        val mDots = Array(size) { TextView(this) }
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

    override fun retrieve(message: Bundle, position: Int) {
        when (position) {
            0 -> {
                when (message.getInt("animo")) {
                    0 -> {

                    }
                    1 -> {

                    }
                    2 -> {

                    }
                    3 -> {

                    }
                    4 -> {

                    }
                    5 -> {

                    }
                    6 -> {

                    }
                    7 -> {

                    }
                    8 -> {

                    }
                    9 -> {

                    }
                }
            }
            1 -> {
                when (message.getInt("dolor")) {
                    0 -> {

                    }
                    1 -> {

                    }
                    2 -> {

                    }
                    3 -> {

                    }
                    4 -> {

                    }
                    5 -> {

                    }
                    6 -> {

                    }
                    7 -> {

                    }
                    8 -> {

                    }
                    9 -> {

                    }
                }
            }
            2 -> {
                when (message.getInt("apetito")) {
                    0 -> {

                    }
                    1 -> {

                    }
                    2 -> {

                    }
                    3 -> {

                    }
                    4 -> {

                    }
                    5 -> {

                    }
                    6 -> {

                    }
                    7 -> {

                    }
                    8 -> {

                    }
                    9 -> {

                    }
                }
            }
            3 -> {
                when (message.getInt("actFis")) {
                    0 -> {
                        viewPager.currentItem = position + 1
                    }
                    1 -> {
                        viewPager.currentItem = position + 1
                    }
                    2 -> {
                        viewPager.currentItem = position + 1
                    }
                }
            }
            4 -> {
                when(message.getInt("ctcto")) {
                    0 -> {
                        viewPager.currentItem = position + 1
                    }
                    1 -> {
                        viewPager.currentItem = position + 1
                    }
                    2 -> {
                        viewPager.currentItem = position + 1
                    }
                    3 -> {
                        viewPager.currentItem = position + 1
                    }
                }
            }
            5 -> {
                when(message.getInt("actSocial")) {
                    0 -> {
                        goHome()
                    }
                    1 -> {
                        goHome()
                    }
                    2 -> {
                        goHome()
                    }
                    3 -> {
                        goHome()
                    }
                }
            }
        }
    }

    private fun goHome() {
        startActivity(Intent(this, Home::class.java))
        finish()
    }
}

