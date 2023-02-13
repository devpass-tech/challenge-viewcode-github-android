package com.devpass.githubapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.data.repository.RepositoryListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryListViewModel(
    private val repository: RepositoryListRepository
):ViewModel() {

    init {
        getListRepositories()
    }

    private fun getListRepositories() {
        repository.getRepositories().enqueue(
            object : Callback<List<Repository>>{
            override fun onFailure(call: Call<List<Repository>>, t: Throwable){
            }
            override fun onResponse(
                call: Call<List<Repository>>, response: Response<List<Repository>>
            ) {
                val repositoryList = response.body() ?: listOf()
            }
        })
    }
}