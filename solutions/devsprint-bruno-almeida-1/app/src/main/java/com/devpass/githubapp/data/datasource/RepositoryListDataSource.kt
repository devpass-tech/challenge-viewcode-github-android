package com.devpass.githubapp.data.datasource

import com.devpass.githubapp.data.model.Repository
import retrofit2.Call

interface RepositoryListDataSource {
    fun getRepositories(username: String): Call<List<Repository>>
}