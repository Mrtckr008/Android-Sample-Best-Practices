package com.mrtckr.livecoding.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ViewingDistanceEntity(
    val visibleDistance: String, val description: String
)
