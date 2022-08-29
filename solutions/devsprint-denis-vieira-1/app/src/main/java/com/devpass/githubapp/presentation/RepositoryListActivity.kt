package com.devpass.githubapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.githubapp.R
import com.devpass.githubapp.data.api.GitHubEndpoint
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.ActivityMainBinding
import com.devpass.githubapp.utils.NetworkUtils
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryListActivity : AppCompatActivity(), RepositoryListAdapter.RepositoryItemListener {

    private lateinit var binding: ActivityMainBinding
    private val cellItemAdapter = RepositoryListAdapter()

    private val snackBarError: Snackbar
        get() = Snackbar.make(
            binding.root,
            R.string.snackbar_error,
            Snackbar.LENGTH_INDEFINITE
        ).apply {
            setAction(R.string.retry) { requestData() }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupLayout()

        requestData()
    }

    private fun requestData() {
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.github.com")
        val endpoint = retrofitClient.create(GitHubEndpoint::class.java)
        val callback = endpoint.getRepositories("devpass-tech")

        callback.enqueue(object : Callback<List<Repository>> {
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                snackBarError.show()
            }

            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                response.body()?.let { list ->
                    cellItemAdapter.repositories = list
                    cellItemAdapter.notifyDataSetChanged()
                } ?: snackBarError.show()
            }
        })
    }

    private fun setupLayout() {
        cellItemAdapter.repositoryItemListener = this

        binding.contentList.repositoriesRecyclerview.layoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        binding.contentList.repositoriesRecyclerview.adapter = cellItemAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                goToSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToSettings() {

    }

    override fun onItemClick() {
        val intent = Intent(this, RepositoryDetailsActivity::class.java)
        startActivity(intent)
    }
}