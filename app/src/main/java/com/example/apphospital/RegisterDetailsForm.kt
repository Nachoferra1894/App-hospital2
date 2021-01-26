package com.example.apphospital

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_register_details_form.*

class RegisterDetailsForm : AppCompatActivity() {

    private lateinit var viewPager : ViewPager

    private lateinit var sliderAdapter:SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_details_form)

        sliderAdapter= SliderAdapter(this)

        regform_slideview.adapter = sliderAdapter

        regform_slideview.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                addDots(position)
            }
            override fun onPageSelected(position: Int) {

            }

        })

        addDots(0)
    }

    @SuppressLint("ResourceAsColor")
    private fun addDots(position: Int) {

        val mDots = Array(3) { TextView(this) }

        for (text in mDots){
            text.text = Html.fromHtml("&#8226")
            text.textSize = 35F
            text.setTextColor(resources.getColor(R.color.azul_registro))

            regform_ll_mdot.addView(text)
        }

        if(position > 0){
            mDots[position].setTextColor(R.color.orange)
        }

    }








    


}