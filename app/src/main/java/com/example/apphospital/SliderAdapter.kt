package com.example.apphospital

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter


class SliderAdapter(private val context:Context): PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return 7
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = if (position == 0) {
            inflater.inflate(R.layout.activity_faltapoco,container,false)
        }else if(position == 1){
            inflater.inflate(R.layout.smoker_slide,container,false)
        }else if(position == 2){
            inflater.inflate(R.layout.smoker_detail_slide,container,false)
        }else if(position == 3){
            inflater.inflate(R.layout.diabetes_slide,container,false)
        }else if(position == 4){
            inflater.inflate(R.layout.diabetes_medication_slide,container,false)
        }else if(position == 5){
            inflater.inflate(R.layout.extra_slide,container,false)
        }else{
            inflater.inflate(R.layout.activity_terminamos,container,false)
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


}