package com.example.projectone.core

interface BaseUseCaseWithoutParams< R > {

    suspend fun invoke() : R

}