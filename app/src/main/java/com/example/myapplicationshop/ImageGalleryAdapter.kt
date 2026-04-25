package com.example.myapplicationshop

import Produkt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.FavoriteAdapter.VH

class ImageGalleryAdapter (
    private val images: List<Int>
):RecyclerView.Adapter<ImageGalleryAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById<ImageView>(R.id.ivItemImg)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_Img, parent, false)
        return VH(view)
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.image.setImageResource(images[position])
    }

}

