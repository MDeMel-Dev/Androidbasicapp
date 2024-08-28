package com.vu.androidbasicapp

import android.app.Application
import android.util.Log

class MyBaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("nit3213", "Application onCreate was called")
    }
}