package com.example.apphospital.Fragments.register

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.smoker_detail_slide.*

private const val position = 1

class SmokerDetailFragment(val retriever: Retriever):Fragment() {

    var time = 0
    var cant = 0
    var answer = Bundle()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View{
        return inflater.inflate(R.layout.smoker_detail_slide, container, false)
    }

    override fun onResume() {
        super.onResume()

        val fadeIn = AnimationUtils.loadAnimation(activity,R.anim.fade_in)
        smkdt_catn_ly.startAnimation(fadeIn)
        smkdt_tmp_ly.startAnimation(fadeIn)
        smkdt_catn_ly.visibility = View.VISIBLE
        smkdt_tmp_ly.visibility = View.VISIBLE

        fun passResult(){
            val timeS = smkdt_edtxt_tiempofum.text
            val cantS = smkdt_edtxt_cantdia.text


            time = smkdt_edtxt_tiempofum.text.toString().toInt()
            cant = smkdt_edtxt_cantdia.text.toString().toInt()

            answer.putInt("time",time)
            answer.putInt("cant",cant)
            retriever.retrieve(answer, position)
        }

        smkdt_edtxt_cantdia.setOnEditorActionListener { v, actionId, event ->
            if(!smkdt_edtxt_tiempofum.text.isEmpty()&&!smkdt_edtxt_cantdia.text.isEmpty() && actionId == EditorInfo.IME_ACTION_DONE){
                passResult()
                true
            }else false
        }

        smkdt_edtxt_tiempofum.setOnEditorActionListener { v, actionId, event ->
            if(!smkdt_edtxt_tiempofum.text.isEmpty()&&!smkdt_edtxt_cantdia.text.isEmpty() && actionId == EditorInfo.IME_ACTION_DONE){
                passResult()
                true
            }else false
        }


    }

    override fun onPause() {
        super.onPause()
        smkdt_catn_ly.visibility = View.INVISIBLE
        smkdt_tmp_ly.visibility = View.INVISIBLE
    }

}