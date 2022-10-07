package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.devpass.githubapp.R
import com.devpass.githubapp.databinding.ActivityMainBinding.inflate
import com.devpass.githubapp.databinding.RepositoryDetailsActivityBinding
import com.devpass.githubapp.databinding.SettingsActivityBinding

class RepositoryDetailsActivity : AppCompatActivity() {

    private lateinit var binding: RepositoryDetailsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RepositoryDetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_seta, null);
        binding.toolbar.setNavigationOnClickListener {

            finish()

        }

        supportFragmentManager.beginTransaction().add(R.id.container_header, RepositoryDetailsHeaderFragment()).commit()

        supportFragmentManager.beginTransaction().add(R.id.container_tabs, RepositoryDetailTabsFragment()).commit()
    }
}