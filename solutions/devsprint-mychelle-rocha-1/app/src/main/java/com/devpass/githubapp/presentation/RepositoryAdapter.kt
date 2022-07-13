package com.devpass.githubapp.presentation

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.RepositoryCellItemBinding
import kotlin.coroutines.coroutineContext

class RepositoryAdapter (private var list: List<Repository> = listOf()):
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RepositoryCellItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = list[position]
        holder.onBind(repository)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder (private val binding: RepositoryCellItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun onBind(repository: Repository){
            binding.tvRepositorio.text = repository.name
            binding.tvOwner.text = repository.owner.login
            Glide.with(itemView)
                .load(repository.owner.avatarUrl)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(180)))
                .into(binding.ivAvatar)
        }

    }

    fun updateList(newList: List<Repository>){
        this.list = newList
        notifyDataSetChanged()
    }
}