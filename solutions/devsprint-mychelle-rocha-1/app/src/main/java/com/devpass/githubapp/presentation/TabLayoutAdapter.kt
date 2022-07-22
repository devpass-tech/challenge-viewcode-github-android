package com.devpass.githubapp.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutAdapter(private val numOfTabs: Int, val list: List<Fragment>, activity:
AppCompatActivity ): FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = numOfTabs

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}