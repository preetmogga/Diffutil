package com.mogga.diffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mogga.diffutil.model.Programming

class Adapter:ListAdapter<Programming,Holder>(DifUtil()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.setData(item)
    }


}

class Holder (itemView: View):RecyclerView.ViewHolder(itemView){
    private val initialText:TextView = itemView.findViewById(R.id.initialText)
    private val nameText:TextView = itemView.findViewById(R.id.nameText)

    fun setData(item:Programming){
        initialText.text = item.initial
        nameText.text = item.name

    }

}

class DifUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Programming>(){
    override fun areItemsTheSame(oldItem: Programming, newItem: Programming): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Programming, newItem: Programming): Boolean {

        return oldItem == newItem

    }

}