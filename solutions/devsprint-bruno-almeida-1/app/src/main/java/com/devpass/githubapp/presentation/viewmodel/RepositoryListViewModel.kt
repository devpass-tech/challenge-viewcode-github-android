package com.devpass.githubapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.data.repository.RepositoryListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RepositoryListViewModel @Inject constructor(
    private val repository: RepositoryListRepository
) : ViewModel() {
    private var _repositoriesList: MutableLiveData<List<Repository>> = MutableLiveData()
    val repositoryList: LiveData<List<Repository>> = _repositoriesList

    fun getListRepositories() {
        repository.getRepositories("devpass-tech").enqueue(
            object : Callback<List<Repository>> {
                override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<List<Repository>>, response: Response<List<Repository>>
                ) {
                    _repositoriesList.value = response.body() ?: listOf()
                }
            })
    }

    fun searchRepository(query: String) {
        repository.getRepositories(query).enqueue(
            object : Callback<List<Repository>> {
                override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<List<Repository>>, response: Response<List<Repository>>
                ) {_repositoriesList.value = response.body() ?: listOf()}
            })
    }
}