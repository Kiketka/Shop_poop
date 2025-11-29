package com.example.myapplicationshop

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DeteilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_deteil)


        val productName = intent.getStringExtra("name") ?: "Хабар"
        val productPrice = intent.getDoubleExtra("price", 0.0)
        val productImageRes = intent.getIntExtra("ImageRes", 0)
        val productdescription = intent.getStringExtra("description") ?: "Описания нет"

        val deteilImage = findViewById<ImageView>(R.id.detailIMG)
        val detailName = findViewById<TextView>(R.id.detailName)
        val detailPryse = findViewById<TextView>(R.id.detailPryse)
        val detailDescription = findViewById<TextView>(R.id.detailDescription)
        val buybtn = findViewById<Button>(R.id.buybtn)
        val bekbtn = findViewById<Button>(R.id.bekbtn)

        deteilImage.setImageResource(productImageRes)
        detailName.text = productName
        detailPryse.text = "$productPrice $"
        detailDescription.text = productdescription


        buybtn.setOnClickListener {
            Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_SHORT).show()
        }

        bekbtn.setOnClickListener {
            finish()
        }
    }
}