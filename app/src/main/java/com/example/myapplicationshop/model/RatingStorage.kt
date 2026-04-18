package com.example.myapplicationshop.model

import android.content.Context
import android.content.Context.MODE_PRIVATE

object RatingStorage {
    fun save(context: Context, produktId: Int, rating: Float) {
        val prefs = context.getSharedPreferences("rating_prefs", MODE_PRIVATE)
        prefs.edit().putFloat(produktId.toString(), rating).apply()
    }

    fun get(context: Context, produktId: Int): Float{
        val prefs = context.getSharedPreferences("rating_prefs", MODE_PRIVATE)
        return prefs.getFloat(produktId.toString(), 0f)
    }
}