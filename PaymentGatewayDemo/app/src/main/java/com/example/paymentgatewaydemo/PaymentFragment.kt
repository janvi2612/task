package com.example.paymentgatewaydemo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.paymentgatewaydemo.databinding.FragmentPaymentBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class PaymentFragment : Fragment() ,PaymentResultListener{

    private  var _binding : FragmentPaymentBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentBinding.inflate(inflater,container,false)
        binding.btnpay.setOnClickListener {
            savePayment(binding.edtamount.text.toString().trim().toInt())
        }
        Checkout.preload(requireContext())
        return binding.root
    }

    private fun savePayment(amount :Int){
        val checkout = Checkout()
        checkout.setKeyID(BuildConfig.RAZOR_KEY)
        try{
            val options = JSONObject()
            options.put("name","Payment Demo")
            options.put("theme.color","#3399cc")
            options.put("currency","INR")
            options.put("amount",amount * 100)
            val retryObj = JSONObject()
            retryObj.put("enabled",true)
            retryObj.put("max_count",4)
            retryObj.put("retry",retryObj)
            checkout.open(requireActivity(),options)
        }catch (e:Exception){

        }


    }

    override fun onPaymentSuccess(p0: String?) {
       binding.txtpaymentstatus.text=p0
        binding.txtpaymentstatus.setTextColor(Color.GREEN)
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        binding.txtpaymentstatus.text=p1
        binding.txtpaymentstatus.setTextColor(Color.RED)
    }


}