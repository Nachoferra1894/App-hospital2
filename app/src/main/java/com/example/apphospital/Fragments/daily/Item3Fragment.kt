package com.example.apphospital.Fragments.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.item3_registrodiario_apetito.*

private const val position = 2


class Item3Fragment(val retriever: Retriever) : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ):View ?{
        val v = inflater.inflate(R.layout.item3_registrodiario_apetito, container, false)

        val answer = Bundle()
        val btn1 = v.findViewById<View>(R.id.btn_menosLoNormal)
        val btn2 = v.findViewById<View>(R.id.btn_normal)
        val btn3 = v.findViewById<View>(R.id.btn_masLoNormal)

        btn1.setOnClickListener {
            answer.putInt("apetito", 0)
            retriever.retrieve(answer, position)
        }

        btn2.setOnClickListener {
            answer.putInt("apetito", 1)
            retriever.retrieve(answer, position)
        }

        btn3.setOnClickListener {
            answer.putInt("apetito", 2)
            retriever.retrieve(answer, position)
        }

        return v

    }
}