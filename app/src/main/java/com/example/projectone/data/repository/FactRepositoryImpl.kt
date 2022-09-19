package com.example.projectone.data.repository

import com.example.projectone.common.network.ApiResult
import com.example.projectone.common.network.handleApiResponse
import com.example.projectone.data.remote.remoteDataSource.FactRemoteDataSource
import com.example.projectone.data.remote.response.FactModelDTO
import com.example.projectone.domain.repository.FactRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class FactRepositoryImpl @Inject constructor(
    private val factRemoteDataSource: FactRemoteDataSource,
) : FactRepository{
    override suspend fun getFacts():ApiResult<FactModelDTO> = handleApiResponse { factRemoteDataSource.getFacts() }

}