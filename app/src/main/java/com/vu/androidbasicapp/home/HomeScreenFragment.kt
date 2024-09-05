package com.vu.androidbasicapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.recyclerview.MyRecyclerviewAdapter


class HomeScreenFragment : Fragment() {

    private lateinit var recyclerviewAdapter: MyRecyclerviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerviewAdapter = MyRecyclerviewAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = recyclerviewAdapter

        recyclerviewAdapter.updateData(getdataForList())
    }

    fun getdataForList() = mutableListOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
}