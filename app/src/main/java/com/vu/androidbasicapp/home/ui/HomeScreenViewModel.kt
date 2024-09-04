package com.vu.androidbasicapp.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    val greetingText = MutableStateFlow("Hello Class")
    val restfulDevApiService = RestfulApiDevRetrofitClient().apiService

    init {
        Log.d("nit3213", "HomeScreenViewModel ViewModel injected ")

        viewModelScope.launch {
            delay(4000)
            val result = restfulDevApiService.getAllObjects()
            val stringToDisplay = result.map { item ->
                item.toString() + "\n\n"
            }
            updateGreetingTextState(stringToDisplay.toString())
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}