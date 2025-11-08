package com.example.myapplicationshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import Produkt
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


private val products = listOf(
    Produkt(id=1, name="Франшиза1", price = 5000000.0, ImageRes =R.drawable.one ),
    Produkt(id=2, name="Франшиза2", price = 8500000.0, ImageRes =R.drawable.two ),
    Produkt(id=3, name="Франшиза3", price = 6000000.0, ImageRes =R.drawable.thre ),
    Produkt(id=4, name="Франшиза4", price = 2000000.0, ImageRes =R.drawable.four ),
    Produkt(id=5, name="Франшиза5", price = 2500000.0, ImageRes =R.drawable.five ),
)

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.`activity_sek`)

    val container = findViewById<LinearLayout>(R.id.Catalog)

        products.forEach{ produkt ->
            val view = layoutInflater.inflate(R.layout.item_product,container, false)

            view.findViewById<ImageView>(R.id.ivProductImage).setImageResource(produkt.ImageRes)
            view.findViewById<TextView>(R.id.tvProductName).text = produkt.name
            view.findViewById<TextView>(R.id.tvProductPrise).text = "${produkt.price} ₽"

            container.addView(view)
        }

    }
}