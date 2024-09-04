package com.vu.androidbasicapp.home.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R

class MySimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView: TextView = view.findViewById(R.id.itemtext)

    fun bind(item: String) {
        textView.text = item
    }
}
