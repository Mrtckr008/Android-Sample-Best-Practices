package com.mrtckr.livecoding.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RainfallForecastEntity(
    val index: String, val description: String
)
