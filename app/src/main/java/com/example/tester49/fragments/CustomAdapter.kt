package com.example.tester49.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tester49.R

import kotlinx.android.synthetic.main.card_view.view.*

class CustomAdapter(private val data:List<String>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val item:MutableList<CardView>
    init {
        this.item= ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view,parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.title.text= data[position]
        item.add(holder.card)
    }



    override fun getItemCount(): Int {
       return data.size
    }
    inner class ViewHolder
    internal constructor(
        itemView: View
    ):RecyclerView.ViewHolder(itemView)
    {
        val title: TextView =itemView.rahul_card
        val card: CardView =itemView.card
    }

}