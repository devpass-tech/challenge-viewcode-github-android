package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.FragmentRepositoryAboutBinding

class RepositoryAboutFragment : Fragment() {

    private var _binding: FragmentRepositoryAboutBinding? = null
    private val binding
        get() = _binding!!

    private val repository by lazy {
        arguments?.get(RepositoryDetailsActivity.ARG_REPOSITORY) as? Repository
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryAboutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            textviewAboutRepository.text = repository?.name
            textviewDescriptionAboutRepository.text = repository?.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getInstance(repository: Repository): RepositoryAboutFragment {
            return RepositoryAboutFragment().apply {
                arguments = bundleOf(RepositoryDetailsActivity.ARG_REPOSITORY to repository)
            }
        }
    }
}