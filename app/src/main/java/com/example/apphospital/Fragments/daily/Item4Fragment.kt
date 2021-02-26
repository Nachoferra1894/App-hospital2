package com.example.apphospital.Fragments.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R

// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
private const val position = 3

class Item4Fragment(val retriever: Retriever) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.item4_registrodiario_hidratacion, container, false)
        val menos1l = v.findViewById<View>(R.id.btn_menos1l)
        val uno2l = v.findViewById<View>(R.id.btn_1o2l)
        val mas2l = v.findViewById<View>(R.id.btn_mas2l)
        var answer = Bundle()

        menos1l.setOnClickListener {
            answer.putInt("actFis", 0)
            retriever.retrieve(answer, position)
        }

        uno2l.setOnClickListener {
            answer.putInt("actFis", 1)
            retriever.retrieve(answer, position)
        }

        mas2l.setOnClickListener {
            answer.putInt("actFis", 2)
            retriever.retrieve(answer, position)
        }

        return v

    }
}