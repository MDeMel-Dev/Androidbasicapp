package com.vu.androidbasicapp.home.network

import com.vu.androidbasicapp.home.data.ResponseItem
import retrofit2.http.GET

interface RestfulApiDevService {

    @GET("objects")
    suspend fun getAllObjects(): List<ResponseItem>
}