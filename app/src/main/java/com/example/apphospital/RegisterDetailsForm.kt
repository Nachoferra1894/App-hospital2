package com.example.apphospital

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.apphospital.Fragments.register.*
import com.example.apphospital.classes.DatPagerAdapter
import kotlinx.android.synthetic.main.activity_register_details_form.*
import kotlinx.android.synthetic.main.activity_viewpager_diario.*


private const val NUM_PAGES = 5

class RegisterDetailsForm() : FragmentActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_details_form)

        val adaptador = DatPagerAdapter(this)
        val fragsList = listOf(SmokerFragment(),SmokerDetailFragment(),DiabetesFragment(),DiabetedMed(),Extras())

        adaptador.fragsListHere.addAll(fragsList)

        val pager = findViewById<ViewPager2>(R.id.regform_slideview_fragments)

        pager.adapter = adaptador
        pager.currentItem = 0
    }

    /*
    @SuppressLint("ResourceAsColor")
    private fun addDots(position: Int) {

        val mDots = Array(5) { TextView(this) }
        regform_ll_mdot.removeAllViews()

        for (text in mDots){
            text.text = Html.fromHtml("&#8226")
            text.textSize = 35F
            text.setTextColor(resources.getColor(R.color.azul_registro))

            regform_ll_mdot.addView(text)
        }

        if(mDots.isNotEmpty()){
            mDots[position].setTextColor(resources.getColor(R.color.orange))
        }

    }

     */
}