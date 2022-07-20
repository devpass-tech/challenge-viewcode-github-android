package com.devpass.githubapp.presentation

import android.widget.Toast
import com.devpass.githubapp.data.api.GitHubEndpoint
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryApi {

    fun getListRepository(searchToolbar: String?) {
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.github.com")
        val endpoint = retrofitClient.create(GitHubEndpoint::class.java)
        val callback = searchToolbar?.let { endpoint.getRepositories(it) }
        callback?.enqueue(object : Callback<List<Repository>> {
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                //Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                response.body()?.let {
                    //setupListRepositoryAdapter(it)
                }
            }
        })
}

}