package com.devpass.githubapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.ItemCellRepositoryBinding

class RepositoryListAdapter : RecyclerView.Adapter<RepositoryCellItem>() {

    private val repositories: List<Repository> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryCellItem {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCellRepositoryBinding.inflate(inflater, parent, false)
        return RepositoryCellItem(binding)
    }

    override fun onBindViewHolder(holder: RepositoryCellItem, position: Int) {
        val item = repositories[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = repositories.size

}