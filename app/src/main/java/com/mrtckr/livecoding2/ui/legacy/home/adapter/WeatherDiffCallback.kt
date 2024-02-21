package com.mrtckr.livecoding2.ui.legacy.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mrtckr.livecoding.domain.entity.WeatherData

object WeatherDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when (newItem) {
            is WeatherData -> {
                (oldItem as? WeatherData)?.cityName == newItem.cityName
            }

            else -> {
                newItem == oldItem
            }
        }
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when (newItem) {
            is WeatherData -> {
                (oldItem as? WeatherData) == newItem
            }

            else -> {
                (newItem as? String) == (oldItem as? String)
            }
        }
    }
}
