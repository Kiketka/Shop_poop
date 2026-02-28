package com.example.myapplicationshop.model

import Produkt
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object CartStorage {
    // вся корзина
    private val items = mutableListOf<Produkt>()

    private val gson = Gson()
    // восстанавливает корзину из памяти телефона
    fun init(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = prefs.getString("cart_json", null)
        if (json != null){
            val type = object : TypeToken<List<Produkt>>() {}.type
            val restored: List<Produkt> = gson.fromJson(json, type)

            items.clear()
            items.addAll(restored)
        }
    }

    fun save(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = gson.toJson(items)
        prefs.edit().putString("cart_json", json).apply()

    }
    fun add_item(context: Context, new_item: Produkt){
        items.add(new_item)
        save(context)
    }

    fun remove(context: Context,old_item: Produkt){
        items.removeAll { it.id == old_item.id }
        save(context)
    }
    fun addCart(new_item: Produkt){
        val CheckInCart = items.any { it.id == new_item.id }

        if (CheckInCart == false){
            items.add(new_item)
        }
    }

    fun remove(old_item: Produkt){
        items.removeAll{it.id == old_item.id}
    }

    fun all() : List<Produkt>{
        return items.toList()
    }

    fun clear(context: Context){
        items.clear()
        save(context)
    }

}