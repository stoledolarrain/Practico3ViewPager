package com.example.practico3viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var img: List<Int>, private val cafeName: String) :
    RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>() {

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        return PageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cafeimages, parent, false))
    }

    override fun getItemCount(): Int {
        return img.size
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.imageView.setImageResource(img[position])
        holder.textView.text = cafeName
    }
}
