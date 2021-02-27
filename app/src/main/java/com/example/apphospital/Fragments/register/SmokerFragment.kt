package com.example.apphospital.Fragments.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.smoker_slide.*


private const val position = 0


class SmokerFragment(val retriever: Retriever):Fragment(){
    lateinit var yes : View
    lateinit var no : View
    lateinit var used: View
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View{
        val rootView = inflater.inflate(R.layout.smoker_slide, container, false)
        yes = rootView.findViewById<View>(R.id.btn_smokeyes)
        used = rootView.findViewById<View>(R.id.btn_smokeused)
        no = rootView.findViewById<View>(R.id.btn_smokeno)
        var answer = Bundle()

        yes.setOnClickListener {
            answer.putInt("smk", 1)
            retriever.retrieve(answer, position)
        }

        no.setOnClickListener {
            answer.putInt("smk", 0)
            retriever.retrieve(answer, position)
        }

        used.setOnClickListener {
            answer.putInt("smk", 2)
            retriever.retrieve(answer, position)
        }

        return rootView
    }

    override fun onStart() {
        super.onStart()
        val fadeIn = AnimationUtils.loadAnimation(activity,R.anim.fade_in)
        yes.startAnimation(fadeIn)
        no.startAnimation(fadeIn)
        used.startAnimation(fadeIn)
        yes.visibility=View.VISIBLE
        no.visibility=View.VISIBLE
        used.visibility=View.VISIBLE

    }

    @SuppressLint("ResourceType")
    override fun onResume() {
        super.onResume()

        val fadeIn = AnimationUtils.loadAnimation(activity,R.anim.fade_in)
        yes.startAnimation(fadeIn)
        no.startAnimation(fadeIn)
        used.startAnimation(fadeIn)
        yes.visibility=View.VISIBLE
        no.visibility=View.VISIBLE
        used.visibility=View.VISIBLE

    }

    override fun onPause() {
        super.onPause()
        yes.visibility=View.INVISIBLE
        no.visibility=View.INVISIBLE
        used.visibility=View.INVISIBLE
    }
}