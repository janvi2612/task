package com.example.calldemo.fragments.calling


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CallingViewModel(finalScore:String ) :ViewModel() {
    private val _cno = MutableLiveData<String>()
    val  score : LiveData<String>
        get() = _cno


    init {

        _cno.value = finalScore
    }
}