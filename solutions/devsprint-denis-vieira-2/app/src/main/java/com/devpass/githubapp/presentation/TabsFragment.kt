package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.githubapp.R
import com.devpass.githubapp.databinding.FragmentRepositoryDetailTabsBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabsFragment : Fragment(R.layout.fragment_repository_detail_tabs) {

    private lateinit var binding: FragmentRepositoryDetailTabsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryDetailTabsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTabs()
    }

    private fun setupTabs() {
        binding.viewPager.adapter = TabAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "About"
                1 -> "Owner"
                2 -> "License"
                else -> ""
            }
        }.attach()
    }
}