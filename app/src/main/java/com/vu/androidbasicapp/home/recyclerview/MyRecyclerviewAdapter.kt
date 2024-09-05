package com.vu.androidbasicapp.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R

class MyRecyclerviewAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private val dataList: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.my_viewholder_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

    fun updateData(data: List<String>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}