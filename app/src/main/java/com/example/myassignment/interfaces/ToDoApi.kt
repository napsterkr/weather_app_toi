package com.example.myassignment.interfaces

import com.example.myassignment.dataModel.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ToDoApi {
    //b25595969a311cb6ca32609485c0f644
    //http://api.weatherstack.com/current?access_key=b25595969a311cb6ca32609485c0f644&query=New%20York

    @GET("current?access_key=b25595969a311cb6ca32609485c0f644&query=New%20York")
    suspend fun getWeatherData( @Query(
        "query"
    ) Qwery: String
    ): Response<WeatherApiResponse>

}