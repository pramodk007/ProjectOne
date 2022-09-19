package com.example.projectone.data.remote.remoteDataSource

import com.example.projectone.data.remote.response.FactModelDTO
import retrofit2.Response

interface FactRemoteDataSource {
    suspend fun getFacts(): Response<FactModelDTO>
}