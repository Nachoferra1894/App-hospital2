package com.example.apphospital.Fragments.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.diabetes_medication_slide.*

private const val position = 3

class DiabetedMed(val retriever: Retriever):Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.diabetes_medication_slide, container, false)

    override fun onPause() {
        super.onPause()
        btn_insulina.visibility=View.INVISIBLE
        btn_metformina.visibility=View.INVISIBLE
        btn_otra.visibility=View.INVISIBLE
    }

    override fun onResume() {
        super.onResume()

        val fadeIn = AnimationUtils.loadAnimation(activity,R.anim.fade_in)
        btn_insulina.startAnimation(fadeIn)
        btn_metformina.startAnimation(fadeIn)
        btn_otra.startAnimation(fadeIn)
        btn_insulina.visibility=View.VISIBLE
        btn_metformina.visibility=View.VISIBLE
        btn_otra.visibility=View.VISIBLE

        val answer = Bundle()

        btn_insulina.setOnClickListener {
            answer.putString("med","Insulina")
            retriever.retrieve(answer, position)
        }

        btn_metformina.setOnClickListener {
            answer.putString("med","Metformina")
            retriever.retrieve(answer, position)
        }

        btn_otra.setOnClickListener {
            answer.putString("med","Otra")
            retriever.retrieve(answer, position)
        }
    }

}