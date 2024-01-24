package com.mrtckr.livecoding.domain.entity

sealed class ResultData<out T> {
    data class Loading<out T>(val data: T? = null) : ResultData<T>()
    data class Success<out T>(val data: T) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()
}
