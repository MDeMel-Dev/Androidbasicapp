package com.vu.androidbasicapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textvalue = intent.getStringExtra(DATA_KEY_MODULE_ID)

        setContentView(R.layout.activity_second_screen)

        val textView: TextView = findViewById(R.id.text)
        textView.text = textvalue
    }
}