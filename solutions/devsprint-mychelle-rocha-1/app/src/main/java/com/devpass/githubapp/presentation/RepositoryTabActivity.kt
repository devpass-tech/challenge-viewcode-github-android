package com.devpass.githubapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.devpass.githubapp.databinding.ActivityMainBinding
import com.devpass.githubapp.databinding.ActivityRepositoryTabBinding
import com.devpass.githubapp.databinding.FragmentRepositoryAboutBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RepositoryTabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRepositoryTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayoutRepository()
    }

    fun tabLayoutRepository() {
        val viewpager = binding.viewPagerTab
        val tablayout = binding.tabLayoutRepository

        viewpager.adapter = TabLayoutAdapter(this)
        viewpager.isUserInputEnabled = false

        TabLayoutMediator(tablayout, viewpager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
            }
        })
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "@string/title_tablayout_about"
            1 -> "@string/title_tablayout_license"
            2 -> "@string/title_tablayout_owner"
            else -> "@string/title_tablayout_about"
        }
    }
}