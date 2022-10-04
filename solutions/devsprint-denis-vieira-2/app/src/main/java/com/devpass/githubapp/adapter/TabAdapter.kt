package com.devpass.githubapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.githubapp.presentation.RepositoryAboutFragmentFragment
import com.devpass.githubapp.presentation.RepositoryLicenseFragment
import com.devpass.githubapp.presentation.RepositoryOwnerFragment

class TabAdapter(
    fragment: Fragment
        ) : FragmentStateAdapter(fragment) {

            private val tabs = listOf(
                RepositoryAboutFragmentFragment(),
                RepositoryOwnerFragment(),
                RepositoryLicenseFragment()
            )

    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabs[position]
    }

}
