package com.example.makeupapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.makeupapi.databinding.ItemMaketestBinding
import com.example.makeupapi.model.response.ProductColor

class MakeuptestAdapter() : RecyclerView.Adapter<MakeuptestAdapter.MyViewHolder>() {



    private var callList = emptyList<ProductColor>()

    class MyViewHolder(private val binding: ItemMaketestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: ProductColor,
        ) {

            binding.itemmk = currentItem


        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMaketestBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }


    override fun getItemCount(): Int {
        return callList.size
    }


    fun setData(Result: List<ProductColor>) {


        val userDiffUtil = com.example.makeupapi.utils.DiffUtilExt(callList, Result)
        val userDiffUtilResult = DiffUtil.calculateDiff(userDiffUtil)
        callList = Result
        userDiffUtilResult.dispatchUpdatesTo(this)

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = callList.getOrNull(position)

        currentItem?.let {
            holder.bind(it)
        }
    }

}