package com.freakeinstein.pelaut.detail

data class WeatherInfo(
    var day: String,
    var status: String,
    var photo: Int,
    var temperature: String,
    var condition: String,
    var speed: String
)