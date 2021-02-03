package com.example.apphospital

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.apphospital.Fragments.register.*
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.classes.DatPagerAdapter
import kotlinx.android.synthetic.main.activity_register_details_form.*



private const val NUM_PAGES = 5

class RegisterDetailsForm() : FragmentActivity(),Retriever {

    private lateinit var viewPager: ViewPager2

    var smokes = 0
    var cant = 0
    var time = 0
    var diabetic = false
    var med :String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_details_form)
        viewPager = findViewById<ViewPager2>(R.id.regform_slideview_fragments)

        val adapter = DatPagerAdapter(this)
        var fragsList = listOf(SmokerFragment(this),SmokerDetailFragment(this),DiabetesFragment(this),DiabetedMed(this),Extras())
        initializeFrags(viewPager,adapter,fragsList,0)

        addDots(0,fragsList.size)

        val pageChangeCallBack = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                addDots(position,fragsList.size)
            }
        }

        viewPager.registerOnPageChangeCallback(pageChangeCallBack)
    }

    private fun initializeFrags(pager:ViewPager2 , adapter:DatPagerAdapter, fragsList:List<Fragment>,current:Int){
        adapter.fragsListHere.addAll(fragsList)
        viewPager.adapter = adapter
        viewPager.currentItem = current
    }

    @SuppressLint("ResourceAsColor")
    private fun addDots(position: Int,size: Int) {

        val mDots = Array(size) { TextView(this) }
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

    override fun retrieve(message: Bundle, position: Int) {
        when(position){
            0 -> {
                when(message.getInt("smk")){
                    0 ->{
                        smokes = 0
                        viewPager.currentItem = position+2
                    }
                    1->{
                        smokes = 1
                        viewPager.currentItem = position + 1
                    }
                    2->{
                        smokes = 2
                        viewPager.currentItem = position + 1
                    }
                }
            }
            1 ->{
                cant = message.getInt("cant")
                time = message.getInt("time")
                viewPager.currentItem = position + 1
            }
            2 ->{
                val bool = message.getBoolean("db")
                if(bool){
                    diabetic = bool
                    viewPager.currentItem = position + 1
                }
                else{
                    diabetic=bool
                    viewPager.currentItem = position + 2
                }
            }
            3->{
                med = message.getString("med")
                viewPager.currentItem = position + 1
            }
            4 ->{

            }

        }
    }

}