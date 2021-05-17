package com.example.myassignment.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myassignment.BR
import com.example.myassignment.R
import com.example.myassignment.di.RetrofitModule
import com.example.myassignment.dataModel.WeatherApiResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class HomeListActivityViewModel(private val service: RetrofitModule) : ViewModel() {

    private val parentJob = Job()


    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    var toDoItemClickListner = MutableLiveData<Void>()
    var progressBarLodingStatus = ObservableField<Boolean>(false)

    var weatherApiResponeDataFromServer = ObservableField<WeatherApiResponse>()

    var isDataFound = ObservableField<Boolean>(true)



    // function to fetch to do List from server
    @ExperimentalCoroutinesApi
    fun fetchWeatherDataFromServer() {
    //    isDataFound.set(false)
        progressBarLodingStatus.set(true)
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getApiService().getWeatherData("Noida")
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        isDataFound.set(true)
                        weatherApiResponeDataFromServer.set(response.body())
                        showDataOnUI()
                        progressBarLodingStatus.set(false)
                    } else {
                        isDataFound.set(false)
                        progressBarLodingStatus.set(false)
                    }

                } catch (e: HttpException) {
                    isDataFound.set(false)
                    progressBarLodingStatus.set(false)
                    Log.d("error1", e.message ?: "Something went wrong")
                } catch (e: Throwable) {
                    isDataFound.set(false)
                    progressBarLodingStatus.set(false)
                    Log.d("error1", e.message ?: "Something went wrong")
                }
            }
        }
    }

    private fun showDataOnUI() {
    //    weatherApiResponeDataForUI.set(listOf(weatherApiResponeDataFromServer.get()?.list?.first()) as List<ListEntity>?)
        }

    @ExperimentalCoroutinesApi
    fun onReloadClick() {
        fetchWeatherDataFromServer()
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}