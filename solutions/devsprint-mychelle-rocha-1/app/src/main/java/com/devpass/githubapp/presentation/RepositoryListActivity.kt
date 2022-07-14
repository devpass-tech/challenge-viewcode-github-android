package com.devpass.githubapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.devpass.githubapp.data.api.GitHubEndpoint
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.ActivityMainBinding
import com.devpass.githubapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy {
        RepositoryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.github.com")
        val endpoint = retrofitClient.create(GitHubEndpoint::class.java)
        val callback = endpoint.getRepositories("devpass-tech")

        callback.enqueue(object : Callback<List<Repository>> {
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                response.body()?.let {
                    getListRepository(it)
                }
            }
        })
    }

    private fun getListRepository(list: List<Repository>) {
        binding.repositoryList.rvRepository.adapter = adapter
        adapter.submitList(list)
    }
}