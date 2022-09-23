package com.devpass.githubapp.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.githubapp.data.model.Repository

class TabAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    private val tabs = listOf(
        RepositoryAboutFragmentFragment(),
        RepositoryOwnerFragment()
    )

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment {
        return tabs[position]
    }
}