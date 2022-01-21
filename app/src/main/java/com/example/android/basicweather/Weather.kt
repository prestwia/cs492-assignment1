package com.example.android.basicweather

data class Weather(
    val month: String,
    val day: Int,
    val text: String,
    val low: String,
    val precipitation: String,
    val high: String,
    val message: String)
