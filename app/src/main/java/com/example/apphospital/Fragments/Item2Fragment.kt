package com.example.apphospital.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apphospital.R

// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
class Item2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ):View = inflater.inflate(R.layout.item2_registrodiario_dolor, container, false)
}