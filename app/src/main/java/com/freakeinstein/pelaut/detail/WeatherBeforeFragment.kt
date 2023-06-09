package com.freakeinstein.pelaut.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.freakeinstein.pelaut.R
import com.freakeinstein.pelaut.databinding.FragmentDetailBinding
import com.freakeinstein.pelaut.databinding.FragmentWeatherBeforeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WeatherBeforeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeatherBeforeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentWeatherBeforeBinding

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
        binding = FragmentWeatherBeforeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvWeather.layoutManager = LinearLayoutManager(requireActivity())
        val dataDay = resources.getStringArray(R.array.data_day)
        val dataStatus = resources.getStringArray(R.array.data_weather)
        val dataImgWeather = resources.obtainTypedArray(R.array.data_img_weather)
        val dataTemperature = resources.getStringArray(R.array.data_temperature)
        val dataCondition = resources.getStringArray(R.array.data_condition)
        val dataSpeed = resources.getStringArray(R.array.data_speed)
        val listWeather = ArrayList<WeatherInfo>()
        for (i in dataDay.indices) {
            val weather = WeatherInfo(dataDay[i], dataStatus[i], dataImgWeather.getResourceId(i, -1), dataTemperature[i], dataCondition[i],dataSpeed[i])
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
         * @return A new instance of fragment WeatherBeforeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WeatherBeforeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}