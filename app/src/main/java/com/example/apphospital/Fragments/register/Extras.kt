package com.example.apphospital.Fragments.register

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.extra_slide.*

private const val position = 4

class Extras(val retriever: Retriever):Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.extra_slide, container, false)

    override fun onResume() {
        super.onResume()
        val answer = Bundle()

        extra_btn_confirm.setOnClickListener {
            val hipBtn = view?.findViewById<RadioButton>(rad_hipertension.checkedRadioButtonId)
            answer.putBoolean("hip",hipBtn == rad_hipertension_yes)

            val epocBtn = view?.findViewById<RadioButton>(rad_epoc.checkedRadioButtonId)
            answer.putBoolean("epoc",epocBtn == rad_epoc_yes)

            val acvBtn = view?.findViewById<RadioButton>(rad_acv.checkedRadioButtonId)
            answer.putBoolean("acv",acvBtn == rad_acv_yes)

            val infBtn = view?.findViewById<RadioButton>(rad_inf.checkedRadioButtonId)
            answer.putBoolean("inf",infBtn == rad_inf_yes)

            retriever.retrieve(answer, position)

        }
    }
}