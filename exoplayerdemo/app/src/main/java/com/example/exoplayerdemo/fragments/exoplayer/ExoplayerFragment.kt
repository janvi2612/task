package com.example.exoplayerdemo.fragments.exoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exoplayerdemo.R
import com.example.exoplayerdemo.databinding.FragmentExoplayerBinding


class exoplayerFragment : Fragment() {
    private var _binding: FragmentExoplayerBinding? = null
    private val binding: FragmentExoplayerBinding
        get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentExoplayerBinding.inflate(inflater, container, false)
        return binding.root
    }


}