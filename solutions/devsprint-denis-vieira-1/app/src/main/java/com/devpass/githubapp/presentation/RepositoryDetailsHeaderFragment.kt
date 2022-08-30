package com.devpass.githubapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.devpass.githubapp.R
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.FragmentRepositoryDetailsHeaderBinding

class RepositoryDetailsHeaderFragment : Fragment() {

    private var _binding: FragmentRepositoryDetailsHeaderBinding? = null
    private val binding
        get() = _binding!!

    private val repository by lazy {
        arguments?.get(RepositoryDetailsActivity.ARG_REPOSITORY) as? Repository
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryDetailsHeaderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (binding) {
            val stars = repository?.stargazersCount ?: 0
            val forks = repository?.forksCount ?: 0

            textviewRepositoryName.text = repository?.name
            textviewRepositoryStars.text =
                resources.getQuantityString(R.plurals.plural_name_repo_stars, stars, stars)
            textviewRepositoryForks.text =
                resources.getQuantityString(R.plurals.plural_name_repo_forks, forks, forks)

            Glide
                .with(root.context)
                .load(repository?.owner?.avatarUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(imageviewRepository)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}