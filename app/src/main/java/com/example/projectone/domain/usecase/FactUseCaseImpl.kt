package com.example.projectone.domain.usecase

import com.example.projectone.common.network.ApiResult
import com.example.projectone.data.remote.response.FactModelDTO
import com.example.projectone.domain.repository.FactRepository
import javax.inject.Inject

class FactUseCaseImpl @Inject constructor(
    private val repository: FactRepository,
) : FactUseCase {

    override suspend fun invoke(): ApiResult<FactModelDTO> {
        return repository.getFacts()
    }
}