package com.example.calldemo.fragments.call

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CallViewModel: ViewModel(){

    val digit_on_screen = StringBuilder()
    val NumberAll = MutableLiveData<String>()



    fun buttonNum(digit: String){
       appendToDigitOnScreen(digit)
   }

    private fun appendToDigitOnScreen(digit: String) {


        digit_on_screen.append(digit)
        NumberAll.value =digit_on_screen.toString()

    }
     fun cancel() {

        val length = digit_on_screen.length
         if(length == 0)
         {

         }else{

             digit_on_screen.deleteCharAt(length - 1)
             NumberAll.value= digit_on_screen.toString()
         }


    }


    }




