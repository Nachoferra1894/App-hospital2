package com.example.apphospital.Fragments.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R


// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class

private const val position = 4

class Item5Fragment(val retriever: Retriever) : Fragment() {
    override fun onCreateView(
/*        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.item5_registrodiario_actividad_fisica, container, false)
}*/
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?{
        val v = inflater.inflate(R.layout.item5_registrodiario_actividad_fisica, container, false)
        val btn1 = v.findViewById<View>(R.id.btn_NoViNadie)
        val btn2 = v.findViewById<View>(R.id.btn_Limitado)
        val btn3 = v.findViewById<View>(R.id.btn_Amgios1h)
        val btn4 = v.findViewById<View>(R.id.btn_Amigos2h)
        var answer = Bundle()

        btn1.setOnClickListener {
            answer.putInt("ctcto", 0)
            retriever.retrieve(answer, position)
        }

        btn2.setOnClickListener {
            answer.putInt("ctcto", 1)
            retriever.retrieve(answer, position)
        }

        btn3.setOnClickListener {
            answer.putInt("ctcto", 2)
            retriever.retrieve(answer, position)
        }

        btn4.setOnClickListener {
            answer.putInt("ctcto", 3)
            retriever.retrieve(answer, position)
        }


        return v

    }

}

