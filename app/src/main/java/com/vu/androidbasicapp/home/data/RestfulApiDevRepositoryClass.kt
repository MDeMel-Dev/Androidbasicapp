package com.vu.androidbasicapp.home.data

import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient
import com.vu.androidbasicapp.home.network.RestfulApiDevService
import javax.inject.Inject

class RestfulApiDevRepositoryClass @Inject constructor(private val restfulDevApiService: RestfulApiDevService) {

    suspend fun getAllObjectsData() = restfulDevApiService.getAllObjects()

    suspend fun getSingleObject(id: Int) = restfulDevApiService.getSingleObject(id)

    suspend fun addSingleObject(item: AddObjectRequest) = restfulDevApiService.addObject(requestBody = item)
}