package com.example.apphospital.Fragments.daily

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apphospital.Home
import com.example.apphospital.R


// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
class Item6Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ):  View?{
        val v = inflater.inflate(R.layout.item6_registrodiario_actividad_social, container, false)
        val btn1 = v.findViewById<View>(R.id.btn_NoViNadie)
        val btn2 = v.findViewById<View>(R.id.btn_Limitado)
        val btn3 = v.findViewById<View>(R.id.btn_Amgios1h)
        val btn4 = v.findViewById<View>(R.id.btn_Amigos2h)

        btn1.setOnClickListener {
            val i = Intent(activity, Home::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0, 0)

        }

        btn2.setOnClickListener {
            val i = Intent(activity, Home::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0, 0)

        }

        btn3.setOnClickListener {
            val i = Intent(activity, Home::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0, 0)

        }

        btn4.setOnClickListener {
            val i = Intent(activity, Home::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0, 0)
        }

        return v

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title="Fragment6"
    }
}