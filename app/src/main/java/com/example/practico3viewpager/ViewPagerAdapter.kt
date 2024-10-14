package com.example.practico3viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// La Clase ViewPagerAdapter recibe una lista de imágenes y el nombre de la cafetería
class ViewPagerAdapter(private var img: List<Int>, private val cafeName: String) :
    RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>() {

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView) // Se obtiene la imagen
        val textView: TextView = itemView.findViewById(R.id.textView) // Se obtiene el nombre de la cafetería
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        return PageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cafeimages, parent, false)) //Muestra las imagenes en el cafeimages.xml
    }

    override fun getItemCount(): Int {
        return img.size // Se obtiene la cantidad de imágenes
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.imageView.setImageResource(img[position]) // Se asigna la imagen
        holder.textView.text = cafeName // Se asigna el nombre de la cafetería
    }
}
