package com.example.makeupapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeupapi.databinding.ItemMakeupBinding
import com.example.makeupapi.model.response.MakeupItem

class MakeupAdapter : RecyclerView.Adapter<MakeupAdapter.MyViewHolder>() {



    private var callList = emptyList<MakeupItem>()
    class MyViewHolder(private val binding: ItemMakeupBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            currentItem: MakeupItem,
            ) {
            binding.itemmakeup = currentItem
            var childadp = MakeuptestAdapter()
            binding.recyclerviews.layoutManager = LinearLayoutManager(binding.root.context,
                LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerviews.adapter = childadp
            childadp.setData(currentItem.productColors?.filterNotNull() ?: emptyList())


        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMakeupBinding.inflate(layoutInflater, parent, false)
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


    fun setData(Result: List<MakeupItem>) {

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
