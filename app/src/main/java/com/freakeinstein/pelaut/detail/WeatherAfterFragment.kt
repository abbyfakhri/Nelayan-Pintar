package com.freakeinstein.pelaut.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.freakeinstein.pelaut.R
import com.freakeinstein.pelaut.databinding.FragmentWeatherAfterBinding
import com.freakeinstein.pelaut.databinding.FragmentWeatherBeforeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WeatherAfterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeatherAfterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentWeatherAfterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeatherAfterBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvWeather.layoutManager = LinearLayoutManager(requireActivity())
        val dataDay = resources.getStringArray(R.array.data_day)
        val dataImgWeather = resources.obtainTypedArray(R.array.data_img_weather_after)
        val dataTemperature = resources.getStringArray(R.array.data_temperature_after)
        val dataCondition = resources.getStringArray(R.array.data_condition_after)
        val listWeather = ArrayList<WeatherInfo>()
        for (i in dataDay.indices) {
            val weather = WeatherInfo(dataDay[i], dataImgWeather.getResourceId(i, -1), dataTemperature[i],dataCondition[i])
            listWeather.add(weather)
        }
        binding.rvWeather.adapter = WeatherDetailAdapter(listWeather)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WeatherAfterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WeatherAfterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}