package com.vu.androidbasicapp.home.ui.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.data.ResponseItem

class ResponseItemViewHolder(view: View,private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.itemNametext)
    private val id: TextView = view.findViewById(R.id.itemIdText)
    private val details: TextView = view.findViewById(R.id.detailsText)
    private val button: Button = view.findViewById(R.id.navigationButton)

    fun bind(item: ResponseItem) {
        name.text = item.objectName
        id.text = "Id: " + item.id
        val showDetails = if (item.dataSection.isNullOrEmpty()) View.INVISIBLE else View.VISIBLE
        details.visibility = showDetails
        button.visibility = showDetails

        if (showDetails == View.VISIBLE) {
            button.setOnClickListener {
                navigationFunction(item)
            }
        }
    }
}
