package com.mrtckr.livecoding.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class FeltTemperatureEntity(
    val degree: Int,
    val description: String
)
