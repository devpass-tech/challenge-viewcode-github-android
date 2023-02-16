package com.devpass.githubapp.data.repository

import com.devpass.githubapp.data.datasource.RepositoryListDataSource
import com.devpass.githubapp.data.model.Repository
import retrofit2.Call

class RepositoryListRepositoryImpl(
    private val repositoryListDataSource: RepositoryListDataSource
) : RepositoryListRepository {

    override fun getRepositories(query: String): Call<List<Repository>> {
        return repositoryListDataSource.getRepositories(query)
    }
}