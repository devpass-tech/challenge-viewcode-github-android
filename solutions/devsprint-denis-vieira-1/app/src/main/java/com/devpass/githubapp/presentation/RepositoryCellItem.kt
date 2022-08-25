package com.devpass.githubapp.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.githubapp.R
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.ItemCellRepositoryBinding

class RepositoryCellItem(
    private val binding: ItemCellRepositoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Repository) {
        with(binding){
            textviewRepositoryName.text = item.name
            textviewOwnerName.text = item.owner.login

            Glide
                .with(root.context)
                .load(item.owner.avatarUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(imageviewAvatar)
        }
    }
}