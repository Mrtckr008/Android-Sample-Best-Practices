package com.mrtckr.livecoding2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.Weather
import com.mrtckr.livecoding2.databinding.FragmentHomeBinding
import com.mrtckr.livecoding2.ui.home.adapter.WeatherAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

private const val EDIT_TEXT_CONTENT = "editTextContent"

@AndroidEntryPoint
class HomeFragment @Inject constructor() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var weatherAdapter: WeatherAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        viewModel.getWeatherData("istanbul")
        viewModel.getCapitalWeatherData("berlin")
        viewModel.getSecondCityWeatherData("vienna")

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.combinedWeatherFlow.collectLatest { (weatherData, capitalWeatherData) ->
                    setupUI(weatherData, capitalWeatherData)
                }
            }
        }

        viewModel.weatherDataLiveData.observe(viewLifecycleOwner) {
            when(it) {
                is ResultData.Success -> {
                    //TODO: UI
                }
                is ResultData.Error -> {

                }
                is ResultData.Loading -> {

                }
            }
        }

        /* WAY 3 If you want to get one value asFlow
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getWeatherFlowData("barcelona").collectLatest { result ->
                    when (result) {
                        is ResultData.Success -> {
                            // TODO: UI
                            setupUI(weather = result.data)
                        }
                        is ResultData.Loading -> {

                        }
                        is ResultData.Error -> {

                        }
                    }
                }
            }
        }
         */

        /* WAY 4 - If want to do something one by one
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.weatherData.collect { result ->
                when (result) {
                    is ResultData.Success -> {
                        // TODO: UI
                    }

                    is ResultData.Error -> {

                    }

                    is ResultData.Loading -> {

                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.capitalWeatherData.collect { result ->
                when (result) {
                    is ResultData.Success -> {
                        // TODO: UI
                    }

                    is ResultData.Error -> {
                        val exception = result.exception
                    }

                    is ResultData.Loading -> {

                    }
                }
            }
        }
         */
    }

    private fun setupUI(weatherData: ResultData<Weather>, capitalWeatherData: ResultData<Weather>) {
        val allWeatherList: ArrayList<Weather> = arrayListOf()
        when (weatherData) {
            is ResultData.Success -> {
                allWeatherList.add(weatherData.data)
            }

            is ResultData.Error -> {
                val exception = weatherData.exception
            }

            is ResultData.Loading -> {

            }
        }

        when (capitalWeatherData) {
            is ResultData.Success -> {
                allWeatherList.add(capitalWeatherData.data)
            }

            is ResultData.Error -> {
                val exception = capitalWeatherData.exception
            }

            is ResultData.Loading -> {

            }
        }
        weatherAdapter = WeatherAdapter(allWeatherList)
        binding.weatherRecyclerView.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(EDIT_TEXT_CONTENT, binding.editText.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        savedInstanceState?.getString(EDIT_TEXT_CONTENT)?.let { content ->
            binding.editText.setText(content)
        }
    }
}
