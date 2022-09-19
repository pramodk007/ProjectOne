package com.example.projectone.di

import com.example.projectone.data.remote.remoteDataSource.FactRemoteDataSource
import com.example.projectone.data.repository.FactRepositoryImpl
import com.example.projectone.domain.repository.FactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideFactRepository(
        factRemoteDataSource: FactRemoteDataSource
    ): FactRepository = FactRepositoryImpl(factRemoteDataSource)
}