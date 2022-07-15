package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.devpass.githubapp.data.model.Owner
import com.devpass.githubapp.databinding.RepositoryOwnerFragmentBinding

class RepositoryOwnerFragment : Fragment() {

    private var _binding: RepositoryOwnerFragmentBinding? = null

    private val binding get() = _binding!!
    private lateinit var owner: Owner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RepositoryOwnerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repositoryOwner(owner)
    }

    private fun repositoryOwner(owner: Owner) {
        binding.tvOwnerName.text = owner.login
        binding.tvOwnerBio.text = owner.url
        Glide.with(binding.root)
            .load(owner.avatarUrl)
            .into(binding.ivOwnerAvatar)
    }
}