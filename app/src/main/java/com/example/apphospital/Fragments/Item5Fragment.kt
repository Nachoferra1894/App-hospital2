package com.example.apphospital.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.apphospital.R


// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
class Item5Fragment : Fragment() {
    override fun onCreateView(
/*        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.item5_registrodiario_actividad_fisica, container, false)
}*/
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?{
        val v = inflater.inflate(R.layout.item5_registrodiario_actividad_fisica, container, false)
        val btn1 = v.findViewById<View>(R.id.btn_No)
        val btn2 = v.findViewById<View>(R.id.btn_m30min)
        val btn3 = v.findViewById<View>(R.id.btn_30y60min)
        val btn4 = v.findViewById<View>(R.id.btn_mas60min)

        btn1.setOnClickListener {
            val fragment = Item6Fragment()
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
                .replace(R.id.frameForFragments, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }

        btn2.setOnClickListener {
            val fragment = Item6Fragment()
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
            val fragment = Item6Fragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
                .replace(R.id.frameForFragments, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }

        btn4.setOnClickListener {
            val fragment = Item6Fragment()
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
        requireActivity().title="Fragment5"
    }

    @Override
    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) AnimationUtils.loadAnimation(
            activity,
            R.anim.fade_in
        ) else AnimationUtils.loadAnimation(
            activity, R.anim.fade_out
        )
    }

}

