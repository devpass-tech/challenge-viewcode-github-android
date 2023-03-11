package com.devpass.githubapp.data.repository

import com.devpass.githubapp.data.datasource.RepositoryListDataSource
import com.devpass.githubapp.data.model.Repository
import retrofit2.Call
import javax.inject.Inject

class RepositoryListRepositoryImpl @Inject constructor(
    private val repositoryListDataSource: RepositoryListDataSource
) : RepositoryListRepository {

    override fun getRepositories(query: String): Call<List<Repository>> {
        return repositoryListDataSource.getRepositories(query)
    }
}