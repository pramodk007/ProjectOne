package com.example.projectone.data.remote.remoteDataSource

import com.example.projectone.data.remote.api.FactApiService
import com.example.projectone.data.remote.response.FactModelDTO
import retrofit2.Response
import javax.inject.Inject

class FactRemoteDataSourceImpl @Inject constructor(
    private val factApiService: FactApiService
) : FactRemoteDataSource {
    override suspend fun getFacts(): Response<FactModelDTO> {
        return factApiService.getFacts()
    }
}