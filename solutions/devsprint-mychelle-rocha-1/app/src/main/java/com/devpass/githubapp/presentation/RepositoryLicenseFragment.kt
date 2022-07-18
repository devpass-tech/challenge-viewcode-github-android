package com.devpass.githubapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.githubapp.data.model.License
import com.devpass.githubapp.databinding.RepositoryLicenseFragmentBinding

class RepositoryLicenseFragment : Fragment() {

    private lateinit var binding: RepositoryLicenseFragmentBinding
    private lateinit var license: License

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RepositoryLicenseFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repositoryLicense(license)
    }

    private fun repositoryLicense(license: License) {
        binding.tvLicenseName.text = license.name
        binding.tvLicenseCod.text = license.key
    }
}