package com.vu.androidbasicapp.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R

class MyRecyclerViewAdapter(private val dataList: MutableList<String> = mutableListOf()) : RecyclerView.Adapter<MySimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySimpleViewHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.item_layout_restful_api_dev, parent, false)
        return MySimpleViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MySimpleViewHolder, position: Int) {
        viewHolder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun setData(newDataList: List<String>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}