package com.devpass.githubapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.githubapp.R
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.ActivityMainBinding
import com.devpass.githubapp.databinding.ContentRepositoryListBinding
import com.devpass.githubapp.databinding.FragmentRepositoryAboutBinding

class RepositoryAboutFragment : Fragment() {
    private var _binding: FragmentRepositoryAboutBinding? = null

    private val binding get() = _binding!!
    private lateinit var repository: Repository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryAboutBinding.inflate(inflater, container, false)
        return binding.root
        repositoryAbout(repository)
    }

    private fun repositoryAbout(repository: Repository) {
        binding.txtDescriptionAboutRepository.text = repository.description
    }
}