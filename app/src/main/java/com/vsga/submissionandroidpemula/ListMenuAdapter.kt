package com.vsga.submissionandroidpemula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMenuAdapter(private val listMenu: ArrayList<Menu>) : RecyclerView.Adapter<ListMenuAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_menu, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, duration,photo) = listMenu[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDuration.text = duration
    }


    override fun getItemCount(): Int = listMenu.size


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_photo_item)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDuration  : TextView = itemView.findViewById(R.id.tv_item_time)
    }

}