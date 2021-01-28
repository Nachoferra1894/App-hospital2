package com.example.apphospital

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter


class SliderAdapterDiario(private val context: Context): PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return 6
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = if (position == 0) {
            inflater.inflate(R.layout.item1_registrodiario_estado_de_animo,container,false)
        }else if(position == 1){
            inflater.inflate(R.layout.item2_registrodiario_dolor,container,false)
        }else if(position == 2){
            inflater.inflate(R.layout.item3_registrodiario_apetito,container,false)
        }else if(position == 3){
            inflater.inflate(R.layout.item4_registrodiario_hidratacion,container,false)
        }else if(position == 4){
            inflater.inflate(R.layout.item5_registrodiario_actividad_fisica,container,false)
        }else{
            inflater.inflate(R.layout.item6_registrodiario_actividad_social,container,false)
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


}