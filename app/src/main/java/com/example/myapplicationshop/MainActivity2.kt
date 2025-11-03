package com.example.myapplicationshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.`activity_sek`)

        val btn_Stop = findViewById<Button>(R.id.btntwo)

        btn_Stop.setOnClickListener {
            //Toast.makeText(this, "Страница временно не работает", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
    }
}