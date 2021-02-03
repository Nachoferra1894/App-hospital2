package com.example.apphospital.Fragments.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.diabetes_slide.*

private const val position = 2

class DiabetesFragment(val retriever: Retriever):Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.diabetes_slide, container, false)

    override fun onResume() {
        super.onResume()
        var answer = Bundle()

        btn_diabetesyes.setOnClickListener {
            answer.putBoolean("db",true)
            retriever.retrieve(answer, position)
        }

        btn_diabetesno.setOnClickListener {
            answer.putBoolean("db",false)
            retriever.retrieve(answer, position)
        }
    }
}