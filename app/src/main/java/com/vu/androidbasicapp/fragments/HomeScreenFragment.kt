package com.vu.androidbasicapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.model.Student

class HomeScreenFragment: Fragment() {

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToDashboardFragment(greetingText = "hey! I'm the Dashboard screen", greetingNumber = 23, student = Student("John", age = 22))
            findNavController().navigate(action)
        }
    }
}