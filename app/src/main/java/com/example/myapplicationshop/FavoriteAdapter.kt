package com.example.myapplicationshop

import Produkt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.CartAdapter.VH
import com.example.myapplicationshop.model.FavoriteStorage

class FavoriteAdapter (
    private val items: MutableList<Produkt>
    ):RecyclerView.Adapter<FavoriteAdapter.VH>() {

        class VH(view: View) : RecyclerView.ViewHolder(view){
            val image: ImageView = view.findViewById<ImageView>(R.id.ivProductImage)
            val name: TextView = view.findViewById<TextView>(R.id.tvProductName)
            val prise: TextView = view.findViewById<TextView>(R.id.tvProductPrise)
            val button: Button = view.findViewById<Button>(R.id.btnDetails)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return VH(view)
    }
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val product = items[position]

        holder.image.setImageResource(product.ImageRes)
        holder.name.text = product.name
        holder.prise.text = "${product.price} ₽"
        holder.button.visibility = View.GONE

        holder.itemView.setOnClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Удаление товара из истории")
                .setMessage("Удалить товар из избранного?")
                .setPositiveButton("Да") { _, _ ->
                    val currentPosition = holder.adapterPosition
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        val itemToRemove = items[currentPosition]
                        FavoriteStorage.remove(holder.itemView.context, itemToRemove)
                        items.removeAt(currentPosition) //удаление
                        notifyItemRemoved(currentPosition)
                    }
                }
                .setNegativeButton("Нет", null)
                .show()

        }

    }


    }
