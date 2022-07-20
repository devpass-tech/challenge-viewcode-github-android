package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devpass.githubapp.R
import com.devpass.githubapp.data.api.GitHubEndpoint
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.ActivityMainBinding
import com.devpass.githubapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val SEARCH_REPOSITORY = "devpass-tech"

class RepositoryListActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy {
        RepositoryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        getListRepository(SEARCH_REPOSITORY)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val searchView = menu.findItem(R.id.serch_toolbar).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(searchRepository: String?): Boolean {
        val api = RepositoryApi()
        api.getListRepository(searchRepository)
        return true
    }

    override fun onQueryTextChange(searchRepository: String?): Boolean {
        return true
    }


    private fun setupListRepositoryAdapter(list: List<Repository>) {
        binding.repositoryList.rvRepository.adapter = adapter
        adapter.submitList(list)
    }
}
