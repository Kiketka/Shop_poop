package com.example.myapplicationshop

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.model.CartStorage

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)

        val rv = findViewById<RecyclerView>(R.id.rvCartList)
        val tvTotak = findViewById<TextView>(R.id.tvCartTotalSumm)
        val btnClear = findViewById<Button>(R.id.btnClearCart)

        val items = CartStorage.all()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = CartAdapter(items)


        var total = 0.0
        for (elem in items){
            total += elem.price
        }
        tvTotak.text = "Итого: ${total} ₽"
        btnClear.setOnClickListener {
            CartStorage.clear()
            rv.adapter = CartAdapter(emptyList())
            tvTotak.text = "Итого: 0 "
        }
    }
}