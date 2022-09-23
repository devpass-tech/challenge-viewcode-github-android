package com.devpass.githubapp.presentation

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.devpass.githubapp.R
import com.devpass.githubapp.databinding.SettingsActivityBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: SettingsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SettingsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarSettings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarSettings.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_seta, null);
        binding.toolbarSettings.setNavigationOnClickListener {

            finish()

        }

    }
}