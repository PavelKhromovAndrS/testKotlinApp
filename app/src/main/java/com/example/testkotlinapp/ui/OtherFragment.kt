package com.example.testkotlinapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import com.example.testkotlinapp.R

class OtherFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val backButton: Button = view.findViewById(R.id.back_button)
        backButton.setOnClickListener(View.OnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_otherFragment_to_mainFragment);
        })

    }
}