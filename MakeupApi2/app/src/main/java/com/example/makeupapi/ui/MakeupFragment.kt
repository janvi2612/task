package com.example.makeupapi.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makeupapi.R
import com.example.makeupapi.databinding.FragmentMakeupBinding
import com.example.makeupapi.model.response.MakeupItem
import com.example.makeupapi.model.response.ProductColor
import com.example.makeupapi.utils.NetworkResult
import com.example.makeupapi.utils.snackBar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MakeupFragment : Fragment() {
    private var _binding: FragmentMakeupBinding?=null
    private val binding get()=_binding!!
    private val ViewModel: MakeupViewModel by viewModels()
    private lateinit var adapter: MakeupAdapter
    private lateinit var adapter1:MakeuptestAdapter
    private var lastquery = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMakeupBinding.inflate(inflater,container,false)
        setupUi()
        setoverview()
        setoverviews()
        return binding.root

    }

    private fun setupUi() {
        adapter = MakeupAdapter()


        adapter1 = MakeuptestAdapter()

        var list = ArrayList<MakeupItem>()
        var lists = ArrayList<ProductColor>()
        Log.e("listdata", "$lists")
        //Log.e("DATA", it.toString())
        for (i in list) {

            if (i?.brand?.lowercase(Locale.ROOT)!!.contains(binding.searchView.query)) {

                list.add(i)
            }

        }
        if (list.isEmpty()) {


        } else {
            Timber.e(list.toString())

            adapter.setData(list)


        }



        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerview.adapter = adapter




        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty() && query != lastquery) {
                    lastquery = query
                    ViewModel.getdatafromApimakeup(query.toString())
                }
                return true

            }


            override fun onQueryTextChange(newText: String?): Boolean {

                if (!newText.isNullOrEmpty() && newText != lastquery) {
                    lastquery = newText
                    ViewModel.getdatafromApimakeup(newText.toString())
                }

                return true
            }

        })

    }

    private fun setoverview() {
        ViewModel.allUsers.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->


            when (respon) {
                is NetworkResult.Error -> {
                    respon.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {



                }
                is NetworkResult.Success -> {
                    respon.data?.let {


                        adapter.setData(it)

                    }




                }
            }

        })


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




    private fun setoverviews() {
        ViewModel.allUsersproduct.observe(viewLifecycleOwner,androidx.lifecycle.Observer{ respon ->

            when (respon) {
                is NetworkResult.Error -> {
                    respon.message?.snackBar(requireView(), requireContext())
                }
                is NetworkResult.Loading -> {


                }
                is NetworkResult.Success -> {
                    respon.data?.let {


                        adapter1.setData(it)
                        Log.e("listdatasss", "${it.toString()}")


                    }

                }
            }

        })


    }

}