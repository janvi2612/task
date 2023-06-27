package com.example.calldemo.fragments.call

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.calldemo.R
import com.example.calldemo.databinding.FragmentCallBinding


class CallFragment : Fragment() {

    lateinit var binding: FragmentCallBinding
   // var digit_on_screen = StringBuilder()
    lateinit var viewModel: CallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(CallViewModel::class.java)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_call,
            container,
            false
        )

        binding.clView = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


       binding.callfloating.setOnClickListener {
           var action = CallFragmentDirections.actionCallFragmentToCallingFragment(viewModel.NumberAll.value.toString())
           findNavController().navigate(action)

       }



        return binding.root
    }


}



