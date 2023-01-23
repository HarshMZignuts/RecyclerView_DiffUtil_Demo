package com.example.recyclerviewdiffutil_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdiffutil_demo.module.Item

class ItemAdapter : ListAdapter<Item,ItemAdapter.MyViewHolder>(DiffUtil()){

    class MyViewHolder(view : View):RecyclerView.ViewHolder(view){
        val id = view.findViewById<TextView>(R.id.tv_id)
        val namei =  view.findViewById<TextView>(R.id.tv_name)
        fun bind(item : Item){
            namei.text = item.name
            id.text = item.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

}