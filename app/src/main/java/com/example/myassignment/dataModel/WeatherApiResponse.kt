package com.example.myassignment.dataModel

data class WeatherApiResponse(
    val current: Current,
    val location: Location,
    val request: Request
)