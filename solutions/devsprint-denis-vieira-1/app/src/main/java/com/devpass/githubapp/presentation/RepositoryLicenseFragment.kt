package com.devpass.githubapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.devpass.githubapp.data.model.Repository
import com.devpass.githubapp.databinding.FragmentRepositoryLicenseBinding

class RepositoryLicenseFragment : Fragment() {

    private var _binding: FragmentRepositoryLicenseBinding? = null
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
        _binding = FragmentRepositoryLicenseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            textviewRepositoryLicenseName.text = repository?.license?.name
            textviewRepositoryLicenseKey.text = repository?.license?.key
            buttonViewmore
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getInstance(repository: Repository): RepositoryLicenseFragment {
            return RepositoryLicenseFragment().apply {
                arguments = bundleOf(RepositoryDetailsActivity.ARG_REPOSITORY to repository)
            }
        }
    }
}