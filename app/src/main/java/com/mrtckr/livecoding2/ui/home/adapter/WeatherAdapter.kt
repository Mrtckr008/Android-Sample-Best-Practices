package com.mrtckr.livecoding2.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrtckr.livecoding.domain.entity.Weather
import com.mrtckr.livecoding2.databinding.HeaderItemBinding
import com.mrtckr.livecoding2.databinding.WeatherItemBinding

private const val TYPE_HEADER = 0
private const val TYPE_WEATHER = 1

class WeatherAdapter(private val weatherItems: List<Weather>) :
    ListAdapter<Weather, RecyclerView.ViewHolder>(WeatherDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEADER -> {
                val binding = HeaderItemBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            }
            else -> {
                val binding = WeatherItemBinding.inflate(inflater, parent, false)
                WeatherViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_HEADER -> (holder as HeaderViewHolder).bind("Header $position")
            TYPE_WEATHER -> (holder as WeatherViewHolder).bind(weatherItems[position])
        }
    }

    override fun getItemCount(): Int = weatherItems.size + (weatherItems.size.div(5))

    override fun getItemViewType(position: Int): Int {
        return if (position % 5 == 0) TYPE_HEADER else TYPE_WEATHER
    }

    class WeatherViewHolder(private val binding: WeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherItem: Weather) {
            binding.cityName.text = weatherItem.cityName
            binding.temperature.text = weatherItem.temperature
        }
    }

    class HeaderViewHolder(private val binding: HeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(headerTitle: String) {
            binding.headerTitle.text = headerTitle
        }
    }
}
