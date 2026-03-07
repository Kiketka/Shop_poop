package com.example.myapplicationshop.model


import Produkt
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.myapplicationshop.model.Order
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object HistoryStorage {
    private val items = mutableListOf<Order>()

    private val gson = Gson()

    fun init(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = prefs.getString("history_json", null)
        if (json != null){
            val type = object : TypeToken<List<Order>>() {}.type
            val restored: List<Order> = gson.fromJson(json, type)

            items.clear()
            items.addAll(restored)
        }
    }

    fun save(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = gson.toJson(items)
        prefs.edit().putString("history_json", json).apply()

    }
    fun add_all(context: Context, new_list: List<Order>){
        for (elem in new_list){
            items.add(elem)
        }
        save(context)
    }

    fun all() : List<Order>{
        return items.toList()
    }
}