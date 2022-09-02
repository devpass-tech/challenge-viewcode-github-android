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
import com.google.android.material.tabs.TabLayoutMediator

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
        setupAvatarImage()
        setupHeader()
        setupTabs()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupHeader() {
        repository?.let {
            val stars = it.stargazersCount
            val forks = it.forksCount

            with(binding) {
                textviewRepositoryName.text = it.name
                textviewRepositoryStars.text =
                    resources.getQuantityString(R.plurals.plural_name_repo_stars, stars, stars)
                textviewRepositoryForks.text =
                    resources.getQuantityString(R.plurals.plural_name_repo_forks, forks, forks)
            }
        }
    }

    private fun setupAvatarImage() {
        repository?.let {
            Glide
                .with(binding.root.context)
                .load(it.owner.avatarUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.imageviewRepository)
        }
    }

    private fun setupTabs() {
        repository?.let {
            binding.pager.adapter = TabAdapter(this, it)

            TabLayoutMediator(binding.tabRepositoryDetails, binding.pager) { tab, position ->
                tab.text = when(position) {
                    0 -> resources.getString(R.string.title_about)
                    1 -> resources.getString(R.string.title_owner)
                    2 -> resources.getString(R.string.title_license)
                    else -> ""
                }
            }.attach()
        }
    }
}