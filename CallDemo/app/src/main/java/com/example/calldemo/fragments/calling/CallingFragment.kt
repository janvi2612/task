package com.example.calldemo.fragments.calling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.calldemo.R
import com.example.calldemo.databinding.FragmentCallingBinding

class CallingFragment : Fragment(){

    lateinit var binding:FragmentCallingBinding
    lateinit var viewModel1: CallingViewModel
     lateinit var viewModelFactory: CallingViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding= DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_calling,
            container,
            false
        )
       // viewModel1 = ViewModelProvider(this).get(CallingViewModel::class.java)
        viewModelFactory = CallingViewModelFactory(CallingFragmentArgs.fromBundle(requireArguments()).score)
        viewModel1 = ViewModelProvider(this, viewModelFactory).get(CallingViewModel::class.java)

        binding.clingView=viewModel1
        binding.lifecycleOwner=viewLifecycleOwner
        binding.timer.start()


        binding.callended.setOnClickListener {
         findNavController().navigate(R.id.action_callingFragment_to_listFragment)
        }
        binding.timer.stop()



        return binding.root
    }

}