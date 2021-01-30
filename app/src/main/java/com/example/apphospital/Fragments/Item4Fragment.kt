package com.example.apphospital.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.apphospital.R
import com.example.apphospital.ScreenSlidePagerActivity

// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
class Item4Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?{
        val v = inflater.inflate(R.layout.item4_registrodiario_hidratacion, container, false)
        val btn1 = v.findViewById<View>(R.id.btn_menos1l)
        val btn2 = v.findViewById<View>(R.id.btn_1o2l)
        val btn3 = v.findViewById<View>(R.id.btn_mas2l)

        btn1.setOnClickListener {
            val fragment = Item5Fragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
                .replace(R.id.frameForFragments, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }

        btn2.setOnClickListener {
            val fragment = Item5Fragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
                .replace(R.id.frameForFragments, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }

        btn3.setOnClickListener {
            val fragment = Item5Fragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
                .replace(R.id.frameForFragments, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }

        return v

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title="Fragment4"
    }
}