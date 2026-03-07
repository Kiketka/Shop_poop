package com.example.myapplicationshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.model.CartStorage
import com.example.myapplicationshop.model.HistoryStorage

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)

        val rv = findViewById<RecyclerView>(R.id.rvHistory)

        val items = HistoryStorage.all()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = HistoryAdapter(items)


    }
}