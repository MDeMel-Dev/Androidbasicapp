package com.vu.androidbasicapp.home.data

import com.squareup.moshi.Json

data class AddObjectRequest(
    @Json(name = "data") val dataSection: Map<String, String>?,
    @Json(name = "name") val objectName: String
)