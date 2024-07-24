package com.vsga.submissionandroidpemula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMenuAdapter(private val listMenu: ArrayList<Menu>) : RecyclerView.Adapter<ListMenuAdapter.ViewHolderClass>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListMenuAdapter.ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row_menu, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = listMenu[position]
        holder.rvImageView.setImageResource(currentItem.photo)
        holder.rvTitle.text = currentItem.name
        holder.rvDuration.text = currentItem.duration
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    class ViewHolderClass(itemview: View): RecyclerView.ViewHolder(itemview){
        val rvImageView: ImageView = itemView.findViewById(R.id.img_photo_item)
        val rvTitle: TextView = itemView.findViewById(R.id.tv_item_name)
        val rvDuration: TextView = itemView.findViewById(R.id.tv_item_time)
    }
}