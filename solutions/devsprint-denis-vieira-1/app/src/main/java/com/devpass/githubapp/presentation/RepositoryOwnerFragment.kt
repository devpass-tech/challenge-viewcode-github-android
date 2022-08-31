package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.devpass.githubapp.R
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.FragmentRepositoryOwnerBinding

class RepositoryOwnerFragment : Fragment() {

    private var _binding: FragmentRepositoryOwnerBinding? = null
    private val binding
        get() = _binding!!

    private val repository by lazy {
        arguments?.get(RepositoryDetailsActivity.ARG_REPOSITORY) as? Repository
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryOwnerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            textviewRepositoryOwnerName.text = repository?.owner?.login
            textviewRepositoryOwnerBio.text = repository?.owner?.url

            Glide
                .with(root.context)
                .load(repository?.owner?.avatarUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(imageviewRepositoryOwner)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getInstance(repository: Repository): RepositoryOwnerFragment {
            return RepositoryOwnerFragment().apply {
                arguments = bundleOf(RepositoryDetailsActivity.ARG_REPOSITORY to repository)
            }
        }
    }
}