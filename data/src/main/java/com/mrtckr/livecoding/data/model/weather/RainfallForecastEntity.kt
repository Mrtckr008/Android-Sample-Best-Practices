@file:OptIn(kotlinx.serialization.InternalSerializationApi::class)
package com.mrtckr.livecoding.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class RainfallForecastEntity(
    val index: String,
    val description: String
)
