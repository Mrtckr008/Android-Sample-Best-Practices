package com.mrtckr.livecoding.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UVIndexEntity(
    val indexPoint: Int,
    val status: String,
)
