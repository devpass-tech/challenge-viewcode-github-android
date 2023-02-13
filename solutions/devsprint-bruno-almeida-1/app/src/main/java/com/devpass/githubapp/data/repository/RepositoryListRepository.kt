package com.devpass.githubapp.data.repository

import com.devpass.githubapp.data.model.Repository
import retrofit2.Call

interface RepositoryListRepository {
    fun getRepositories(): Call<List<Repository>>
}