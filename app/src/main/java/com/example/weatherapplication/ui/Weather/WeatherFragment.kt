package com.example.weatherapplication.ui.Weather


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.weatherapplication.App.Companion.instance
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.FragmentWeatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Date


class WeatherFragment : Fragment() {
    private val viewModel by viewModel<WeatherViewModel>()
    private lateinit var binding: FragmentWeatherBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun update(){
        viewModel.city.value = binding.textInputLayout.text.toString()
        if(!binding.textInputLayout.text.isNullOrEmpty()) {
            viewModel.getWeather()
            binding.refreshLayout.isRefreshing = false
        }
        else {
            Toast.makeText(context, R.string.exception, Toast.LENGTH_SHORT).show()
            binding.refreshLayout.isRefreshing = false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.findButton.setOnClickListener {
            update()
        }
        binding.refreshLayout.setOnRefreshListener {
            update()
        }

        viewModel.name.observe(viewLifecycleOwner, Observer {
            binding.cityName.text = it
        })
        viewModel.windSpeed.observe(viewLifecycleOwner, Observer {
            binding.windSpeed.text = it.toString()
        })
        viewModel.temp.observe(viewLifecycleOwner, Observer {
            binding.temp.text = it.toString() + instance.getString(R.string.temp)
        })
        viewModel.humidity.observe(viewLifecycleOwner, Observer {
            binding.humidity.text = it.toString()
        })
        viewModel.sunrise.observe(viewLifecycleOwner, Observer {
            binding.sunrise.text = convertLongToTime(it!!)
        })
        viewModel.sunset.observe(viewLifecycleOwner, Observer {
            binding.sunset.text = convertLongToTime(it!!)
        })
        viewModel.weather.observe(viewLifecycleOwner, Observer {
            binding.weather.text = it
        })

    }


    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("hh.mm aa")
        return format.format(date)
    }
}