package com.devpass.githubapp.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log 
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.githubapp.adapter.ListAdapter 
import android.view.Menu
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.navigation.ui.AppBarConfiguration
import com.devpass.githubapp.R
import com.devpass.githubapp.data.api.GitHubEndpoint
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.data.model.RepositoryAdapter
import com.devpass.githubapp.databinding.ActivityMainBinding
import com.devpass.githubapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

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

            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {

                response.body()?.toString()?.let { Log.d("BODY", it) }
            }
        })
 
        val listRepositories = listOf(
            RepositoryAdapter(
                "challenge-github-app",
                "devpass-tech",
                "https://avatars.githubusercontent.com/u/81197483?s=200&v=4"
            ),
            RepositoryAdapter(
                "challenge-github-app",
                "devpass-tech",
                "https://avatars.githubusercontent.com/u/81197483?s=200&v=4"
            ),
            RepositoryAdapter(
                "challenge-github-app",
                "devpass-tech",
                "https://avatars.githubusercontent.com/u/81197483?s=200&v=4"
            ),
            RepositoryAdapter(
                "challenge-github-app",
                "devpass-tech",
                "https://avatars.githubusercontent.com/u/81197483?s=200&v=4"
            ),
            RepositoryAdapter(
                "challenge-github-app",
                "devpass-tech",
                "https://avatars.githubusercontent.com/u/81197483?s=200&v=4"
            ),
            RepositoryAdapter(
                "challenge-github-app",
                "devpass-tech",
                "https://avatars.githubusercontent.com/u/81197483?s=200&v=4"
            )
        )

        //Configuração do RecyclerView.
        val adapter = ListAdapter(context = baseContext)

        //Configuração do RecyclerView. Vvvverificar context
        val adapter = ListAdapter(context = baseContext) {
            val intent = Intent(this, RepositoryDetailsActivity::class.java)
            startActivity(intent)
        }

        binding.rvlist.layoutManager = LinearLayoutManager(baseContext)
        binding.rvlist.adapter = adapter
        binding.rvlist.setHasFixedSize(true)

        adapter.setList(listRepositories)

    } 
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java )
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
 
}