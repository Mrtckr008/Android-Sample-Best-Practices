package com.mrtckr.livecoding2.ui.legacy.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding2.R
import com.mrtckr.livecoding2.databinding.HeaderItemBinding
import com.mrtckr.livecoding2.databinding.WeatherItemBinding

private const val TYPE_HEADER = 0
private const val TYPE_WEATHER = 1
private const val GROUP_SIZE = 5
private const val HEADER_PREFIX = "Header: "

class WeatherAdapter : ListAdapter<Any, RecyclerView.ViewHolder>(WeatherDiffCallback) {

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
            TYPE_HEADER -> (holder as HeaderViewHolder).bind("$HEADER_PREFIX $position")
            TYPE_WEATHER -> (holder as WeatherViewHolder).bind(getItem(position) as WeatherData)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is String) TYPE_HEADER else TYPE_WEATHER
    }

    class WeatherViewHolder(private val binding: WeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherDataItem: WeatherData) {
            binding.cityName.text = weatherDataItem.cityName
            binding.temperature.text = itemView.context.getString(
                R.string.temperature,
                weatherDataItem.temperature.toString()
            )
        }
    }

    class HeaderViewHolder(private val binding: HeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(headerTitle: String) {
            binding.headerTitle.text = headerTitle
        }
    }

    fun setWeatherData(newList: ArrayList<WeatherData>) {
        val combinedList: ArrayList<Any> = arrayListOf()
        newList.forEachIndexed { index, weather ->
            if (index % GROUP_SIZE == 0) {
                combinedList.add("$HEADER_PREFIX ${index / GROUP_SIZE + 1}")
            }
            combinedList.add(weather)
        }
        submitList(combinedList)
    }
}
