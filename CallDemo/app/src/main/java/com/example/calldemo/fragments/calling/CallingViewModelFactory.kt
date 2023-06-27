package com.example.calldemo.fragments.calling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CallingViewModelFactory (private val finalScore:String) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CallingViewModel::class.java)) {
            return CallingViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}