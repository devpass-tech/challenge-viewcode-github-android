package com.devpass.githubapp.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.RepositoryCellItemBinding

class RepositoryCellItem(
    private val binding: RepositoryCellItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : Repository){
        with(binding) {
            repositoryCellItemTitle.text = item.name
            repositoryCellItemOwner.text = item.owner.login

            Glide
                .with(root.context)
                .load(item.owner.avatarUrl)
                .circleCrop()
                .into(binding.repositoryCellItemImage)
        }
    }
}