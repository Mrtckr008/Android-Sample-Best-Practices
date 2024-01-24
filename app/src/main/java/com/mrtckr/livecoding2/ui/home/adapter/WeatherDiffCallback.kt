package com.mrtckr.livecoding2.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mrtckr.livecoding.domain.entity.Weather

object WeatherDiffCallback : DiffUtil.ItemCallback<Weather>() {
    override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem.cityName == newItem.cityName
    }

    override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem == newItem
    }
}
