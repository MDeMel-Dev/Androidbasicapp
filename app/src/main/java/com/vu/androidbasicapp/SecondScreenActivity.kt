package com.vu.androidbasicapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.vu.androidbasicapp.model.Student

class SecondScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textvalue = intent.getStringExtra(DATA_KEY_MODULE_ID)
        val studentDetail: Student? = intent.getParcelableExtra(DATA_KEY_STUDENT_DETAILS)

        setContentView(R.layout.activity_second_screen)

        val textView: TextView = findViewById(R.id.text)

        studentDetail?.let { student ->
            textView.text = "$textvalue \nStudent name: ${student.name}\nStudent age: ${student.age}"
        }
    }
}