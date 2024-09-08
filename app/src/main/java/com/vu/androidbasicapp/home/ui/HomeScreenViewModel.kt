package com.vu.androidbasicapp.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.androidbasicapp.home.data.AddObjectRequest
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: RestfulApiDevRepositoryClass) : ViewModel() {

    val greetingText = MutableStateFlow("Hello Class")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())

    init {
        Log.d("nit3213", "HomeScreenViewModel ViewModel injected ")

        viewModelScope.launch {
            val result = repository.getAllObjectsData()
            delay(1000)
            updateGreetingTextState("Api has responded with the following items")
            delay(1000)
            apiResponseObjects.value = result
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}