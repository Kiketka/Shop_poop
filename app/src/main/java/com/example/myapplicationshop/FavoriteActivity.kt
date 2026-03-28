package com.example.myapplicationshop

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.model.CartStorage
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import com.example.myapplicationshop.model.FavoriteStorage
import com.example.myapplicationshop.model.HistoryStorage
import com.example.myapplicationshop.model.Order
import java.util.Date
import java.util.Locale.getDefault

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favorite)

        val rv = findViewById<RecyclerView>(R.id.rvFavoriteList)

        val items = FavoriteStorage.all().toMutableList()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = FavoriteAdapter(items)


    }
}

