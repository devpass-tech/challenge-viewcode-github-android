package com.devpass.githubapp.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import com.devpass.githubapp.R

import com.devpass.githubapp.adapter.TabAdapter
import com.devpass.githubapp.databinding.FragmentRepositoryDetailTabsBinding
import com.google.android.material.tabs.TabLayoutMediator

class RepositoryDetailTabsFragment : Fragment() {

    private lateinit var binding: FragmentRepositoryDetailTabsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentRepositoryDetailTabsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTabs()
    }

    private fun setupTabs() {
        binding.viewPagerTabs.adapter = TabAdapter(this)
        val about: String = getString(R.string.tab_about)
        val owner: String = getString(R.string.tab_owner)
        val license: String = getString(R.string.tab_license)

        TabLayoutMediator(binding.tabsButtonsDetail, binding.viewPagerTabs) { tab, position ->
            tab.text =
                when(position) {
                    0 -> about
                    1 -> owner
                    2 -> license
                    else -> ""
                }
        }.attach()
    }

}