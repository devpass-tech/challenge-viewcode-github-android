package com.devpass.githubapp.data.datasource

import com.devpass.githubapp.data.api.GitHubEndpoint
import com.devpass.githubapp.data.model.Repository
import retrofit2.Call

class RepositoryListDataSourceImpl(
    private val service: GitHubEndpoint
) : RepositoryListDataSource {

    override fun getRepositories(username: String): Call<List<Repository>> {
        return service.getRepositories(username = username)
    }
}