package com.example.projectone.domain.mapper

import com.example.projectone.data.remote.response.FactModelDTO
import com.example.projectone.domain.model.FactModel

fun FactModelDTO.toFactModel():FactModel {
    return FactModel(
        fact, length
    )
}



