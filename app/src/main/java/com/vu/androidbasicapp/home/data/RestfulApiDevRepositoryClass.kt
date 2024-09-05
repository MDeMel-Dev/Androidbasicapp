package com.vu.androidbasicapp.home.data

import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient

class RestfulApiDevRepositoryClass {

    val restfulDevApiService = RestfulApiDevRetrofitClient().apiService

    suspend fun getAllObjectsData() = restfulDevApiService.getAllObjects()

    suspend fun getSingleObject(id: Int) = restfulDevApiService.getSingleObject(id)

    suspend fun addSingleObject(item: AddObjectRequest) = restfulDevApiService.addObject(requestBody = item)
}