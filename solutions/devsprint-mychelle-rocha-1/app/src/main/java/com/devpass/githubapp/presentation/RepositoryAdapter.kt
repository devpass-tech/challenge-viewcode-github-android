package com.devpass.githubapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.RepositoryCellItemBinding

class RepositoryAdapter() :
    ListAdapter<Repository, RepositoryAdapter.RepositoryViewHolder>(RepositoryItemDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            RepositoryCellItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class RepositoryViewHolder(private val binding: RepositoryCellItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(repository: Repository) {
            binding.tvRepository.text = repository.name
            binding.tvOwner.text = repository.owner.login
            Glide.with(itemView)
                .load(repository.owner.avatarUrl)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(180)))
                .into(binding.ivAvatar)
        }
    }
}

private class RepositoryItemDiff : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem == newItem
    }
}