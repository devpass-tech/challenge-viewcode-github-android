package com.devpass.githubapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.githubapp.R
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.RepositoryCellItemBinding

class RepositoryListAdapter(
    private val repositoryList : List<Repository>
) : RecyclerView.Adapter<RepositoryCellItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): RepositoryCellItem {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repository_cell_item, parent, false)
        return RepositoryCellItem(RepositoryCellItemBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    override fun onBindViewHolder(
        holder: RepositoryCellItem, position: Int) {
        holder.bind(repositoryList[position])
    }

}