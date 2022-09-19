package com.example.projectone.data.remote.response

import com.example.projectone.domain.model.FactModel

data class FactModelDTO(
    val fact: String?,
    val length: Int?,
) {
    fun toPresentation(): FactModel {
        return FactModel(
            fact = fact,
            length = length
        )
    }
}