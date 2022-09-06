package com.devpass.githubapp.data.api

import com.devpass.githubapp.data.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubEndpoint {

    @GET("users/{username}/repos")
    fun getRepositories(@Path("username") username: String) : Call<List<Repository>>
}