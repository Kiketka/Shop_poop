package com.example.myapplicationshop.model

import Produkt
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object FavoriteStorage {

    private val items = mutableListOf<Produkt>()

    private val gson = Gson()

    fun init(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = prefs.getString("favorite_json", null)
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
        prefs.edit().putString("favorite_json", json).apply()
    }

    fun add_item(context: Context, new_item: Produkt): Boolean{
        val exists = items.any{it.id == new_item.id}

        if (exists == true){
            return false
        } else {
            items.add(new_item)
            save(context)
            return true
        }


    }

    fun remove(context: Context,old_item: Produkt){
        items.remove(old_item)
        save(context)
    }
    fun all() : List<Produkt>{
        return items.toList()
    }

    fun clear(context: Context){
        items.clear()
        save(context)
    }

}