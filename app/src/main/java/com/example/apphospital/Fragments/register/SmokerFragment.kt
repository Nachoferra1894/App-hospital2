package com.example.apphospital.Fragments.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.smoker_detail_slide.*

private const val position = 0

class SmokerFragment(val retriever:Retriever):Fragment(){
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View{
        val v = inflater.inflate(R.layout.smoker_slide, container, false)
        val yes = v.findViewById<View>(R.id.btn_diabetesyes)
        val used = v.findViewById<View>(R.id.btn_smokeused)
        val no = v.findViewById<View>(R.id.btn_diabetesno)
        var answer = Bundle()

        yes.setOnClickListener {
            answer.putInt("smk",1)
            retriever.retrieve(answer, position)
        }

        no.setOnClickListener {
            answer.putInt("smk",0)
            retriever.retrieve(answer, position)
        }

        used.setOnClickListener {
            answer.putInt("smk",2)
            retriever.retrieve(answer, position)
        }
        return v
    }
}