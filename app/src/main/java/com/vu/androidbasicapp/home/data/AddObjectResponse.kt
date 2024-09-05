package com.vu.androidbasicapp.home.data

import com.squareup.moshi.Json

data class AddObjectResponse(
    @Json(name = "data") val dataSection: Map<String, String>?,
    @Json(name = "id") val id: String,
    @Json(name = "name") val objectName: String,
    @Json(name = "createdAt") val timeStamp: String
)
