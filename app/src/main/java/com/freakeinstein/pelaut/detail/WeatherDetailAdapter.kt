package com.freakeinstein.pelaut.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.freakeinstein.pelaut.databinding.ItemRowWeatherdetailBinding

class WeatherDetailAdapter(private val listWeather: ArrayList<WeatherInfo>): RecyclerView.Adapter<WeatherDetailAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRowWeatherdetailBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherInfo) {
            binding.tvDay.text = item.day
            binding.tvName.text = item.status
            binding.imView.setImageResource(item.photo)
            binding.tvTemperature.text = item.temperature+"\u2103"
            binding.tvSpeed.text = item.speed
            binding.tvCondition.text = item.condition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRowWeatherdetailBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount() = listWeather.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listWeather[position])
    }
}