package com.example.projectone.domain.usecase

import com.example.projectone.common.network.ApiResult
import com.example.projectone.core.BaseUseCaseWithoutParams
import com.example.projectone.data.remote.response.FactModelDTO

interface FactUseCase : BaseUseCaseWithoutParams<ApiResult<FactModelDTO>> {
    override suspend operator fun invoke(): ApiResult<FactModelDTO>
}