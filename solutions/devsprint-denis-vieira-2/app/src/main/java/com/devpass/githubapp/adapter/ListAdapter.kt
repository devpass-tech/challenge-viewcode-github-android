package com.devpass.githubapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.data.model.RepositoryAdapter
import com.devpass.githubapp.databinding.RepositoryCellItemBinding

class ListAdapter (private val context: Context, private val onClickItem: () -> Unit ):
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var listRepository = emptyList<Repository>()
        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */

        class ListViewHolder(val binding: RepositoryCellItemBinding) : RecyclerView.ViewHolder(binding.root)

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            // Create a new view, which defines the UI of the list item
           return ListViewHolder(RepositoryCellItemBinding.inflate(
               LayoutInflater.from(parent.context), parent, false
           ))
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
            val repository = listRepository[position]

            viewHolder.binding.title.text = repository.name
            viewHolder.itemView.setOnClickListener {
                onClickItem()
            }
            viewHolder.binding.subtitle.text = repository.description
            Glide.with(context)
                .load(repository.owner.avatarUrl)
                .into(viewHolder.binding.imageLogo)
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount(): Int {
         return listRepository.size
        }

    fun setList(list: List<Repository>){
        listRepository = list
        notifyDataSetChanged()
    }

}