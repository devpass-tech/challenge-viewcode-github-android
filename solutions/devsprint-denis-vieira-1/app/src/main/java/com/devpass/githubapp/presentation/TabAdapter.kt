package com.devpass.githubapp.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.githubapp.data.model.Repository

class TabAdapter(
    fragment: Fragment,
    repository: Repository
) : FragmentStateAdapter(fragment) {

    private val tabs = listOf(
        RepositoryAboutFragment.getInstance(repository),
        RepositoryOwnerFragment.getInstance(repository),
        RepositoryLicenseFragment.getInstance(repository)
    )

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment {
        return tabs[position]
    }
}