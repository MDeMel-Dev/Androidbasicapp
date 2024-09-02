package com.vu.androidbasicapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.vu.androidbasicapp.fragments.HomeScreenFragment
import com.vu.androidbasicapp.model.Student


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("nit3213", "onCreate: ")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("nit3213", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("nit3213", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("nit3213", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("nit3213", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("nit3213", "onDestroy: ")
    }
}