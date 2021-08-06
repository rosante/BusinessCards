package com.ruzzante.businesscard.ui

import android.graphics.Color
import android.graphics.Color.parseColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ruzzante.businesscard.R
import com.ruzzante.businesscard.model.BackgroundColor

class BackgroundColorAdapter (private val list : List<BackgroundColor>, private val onClick:((String) -> Unit)) : RecyclerView.Adapter<BackgroundColorAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var colorName: TextView = itemView.findViewById(R.id.tv_color_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = list[position]
        holder.colorName.setBackgroundColor(parseColor(item.colorHexa))
        holder.colorName.text = " ${item.colorName}"
        holder.colorName.setOnClickListener { onClick(item.colorHexa) }
    }

    override fun getItemCount() = list.size
}

