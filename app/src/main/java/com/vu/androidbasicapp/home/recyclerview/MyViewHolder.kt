package com.vu.androidbasicapp.home.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R

class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bind(dataValue: String) {
        view.findViewById<TextView>(R.id.viewHoldertext).text = dataValue
    }
}