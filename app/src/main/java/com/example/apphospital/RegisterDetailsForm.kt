package com.example.apphospital

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

        addDots()
    }

    private fun addDots(){

        val mDots = Array(3) { TextView(this) }

        for (text in mDots){
            text.text = Html.fromHtml("&#8226")
            text.textSize = 35F
            text.setTextColor(resources.getColor(R.color.purple2))

            regform_ll_mdot.addView(text)
        }

    }

}