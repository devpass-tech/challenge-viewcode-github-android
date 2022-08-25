package com.devpass.githubapp.presentation

import android.os.Bundle
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

class RepositoryListActivity : AppCompatActivity() {

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
        binding.contentList.repositoriesRecyclerview.layoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        binding.contentList.repositoriesRecyclerview.adapter = cellItemAdapter
    }
}