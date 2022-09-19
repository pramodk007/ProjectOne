package com.example.projectone.core

interface BaseUseCaseWithParams<Params, Result> {

    suspend fun invoke(params: Params): Result

}