package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.githubapp.databinding.FragmentRepositoryAboutBinding

class RepositoryAboutFragment : Fragment() {

    private var _binding: FragmentRepositoryAboutBinding? = null
    private val binding
            get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryAboutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}