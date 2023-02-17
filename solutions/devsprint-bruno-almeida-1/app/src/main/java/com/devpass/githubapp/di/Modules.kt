package com.devpass.githubapp.di

import com.devpass.githubapp.data.api.GitHubEndpoint
import com.devpass.githubapp.data.datasource.RepositoryListDataSource
import com.devpass.githubapp.data.datasource.RepositoryListDataSourceImpl
import com.devpass.githubapp.data.repository.RepositoryListRepository
import com.devpass.githubapp.data.repository.RepositoryListRepositoryImpl
import com.devpass.githubapp.presentation.viewmodel.RepositoryListViewModel
import com.devpass.githubapp.utils.NetworkUtils
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Modules {

    @Binds
    abstract fun bindRepositoryListDataSource(
        repositoryListDataSource: RepositoryListDataSourceImpl
    ): RepositoryListDataSource

    @Binds
    abstract fun bindRepositoryListRepository(
        repositoryListRepository: RepositoryListRepositoryImpl
    ): RepositoryListRepository


}

@Module
@InstallIn(SingletonComponent::class)
class Module2 {
    @Provides
    fun provideGitHubEndpoint(): GitHubEndpoint {
        return NetworkUtils
            .getRetrofitInstance
            .create(GitHubEndpoint::class.java)
    }
}

@Module
@InstallIn(ActivityComponent::class)
class Module3 {
    @Provides
    fun provideRepositorListViewModel(
        repository: RepositoryListRepository
    ): RepositoryListViewModel {
        return RepositoryListViewModel(repository)
    }
}