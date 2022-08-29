package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.devpass.githubapp.databinding.ActivityDetailsRepositoryBinding

class RepositoryDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsRepositoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.repositoryToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}