package com.example.projectone.domain.repository

import com.example.projectone.common.network.ApiResult
import com.example.projectone.data.remote.response.FactModelDTO

interface FactRepository {
    suspend fun getFacts(): ApiResult<FactModelDTO>
}