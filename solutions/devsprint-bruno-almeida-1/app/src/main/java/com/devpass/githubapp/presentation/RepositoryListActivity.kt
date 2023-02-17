package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.devpass.githubapp.R
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.ActivityMainBinding
import com.devpass.githubapp.presentation.viewmodel.RepositoryListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RepositoryListActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: RepositoryListViewModel

    private lateinit var adapter: RepositoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        viewModel.repositoryList.observe(this) {
            setupRv(it)
        }
        viewModel.getListRepositories()
    }

    private fun setupRv(repositoryList: List<Repository>) {
        adapter = RepositoryListAdapter(repositoryList)
        binding.contentRepositoryListRv.adapter = adapter
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search_button -> {
                true
            }
            R.id.action_settings -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchView = menu.findItem(R.id.search_button).actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return true
    }

    private fun observer() {
        viewModel.repositoryList.observe(this) {
            adapter.updateList(it as MutableList<Repository>)
        }
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        viewModel.searchRepository(p0 ?: "")

        return true
    }

    override fun onQueryTextChange(p0: String): Boolean {
        p0.let {
            if (it.isEmpty()) {
                viewModel.getListRepositories()
            }
        }
        return true
    }


}