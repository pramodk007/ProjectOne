package com.example.projectone.di

import com.example.projectone.domain.repository.FactRepository
import com.example.projectone.domain.usecase.FactUseCase
import com.example.projectone.domain.usecase.FactUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsUseCase(
        repository: FactRepository
    ): FactUseCase = FactUseCaseImpl(repository)
}