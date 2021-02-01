package com.example.apphospital.classes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DatPagerAdapter(fragactivity: FragmentActivity) : FragmentStateAdapter(fragactivity) {
    var fragsListHere = mutableListOf<Fragment>()
    override fun getItemCount():Int = fragsListHere.size
    override fun createFragment(position: Int): Fragment = fragsListHere[position]
}