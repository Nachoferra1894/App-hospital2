package com.example.apphospital

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_register_details_form.*

class RegisterDetailsForm : AppCompatActivity() {

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

            }
            override fun onPageSelected(position: Int) {
                addDots(position)
            }

        })

        addDots(0)
    }

    @SuppressLint("ResourceAsColor")
    private fun addDots(position: Int) {

        val mDots = Array(7) { TextView(this) }
        regform_ll_mdot.removeAllViews()

        for (text in mDots){
            text.text = Html.fromHtml("&#8226")
            text.textSize = 35F
            text.setTextColor(resources.getColor(R.color.azul_registro))

            regform_ll_mdot.addView(text)
        }

        if(position == 0 || position == mDots.size-1){
            regform_ll_mdot.setBackgroundColor(resources.getColor(R.color.purple1))
        }
        else{
            regform_ll_mdot.setBackgroundColor(resources.getColor(R.color.white))
        }

        if(mDots.isNotEmpty()){
            mDots[position].setTextColor(resources.getColor(R.color.orange))
        }

    }
}