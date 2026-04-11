package com.example.myapplicationshop

import Produkt
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationshop.model.CartStorage
import com.example.myapplicationshop.model.FavoriteStorage

class DeteilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_deteil)


        val productName = intent.getStringExtra("name") ?: "Хабар"
        val productPrice = intent.getDoubleExtra("price", 0.0)
        val productImageRes = intent.getIntExtra("ImageRes", 0)
        val productdescription = intent.getStringExtra("description") ?: "Описания нет"
        val productId = intent.getIntExtra("id", -1)// -1 = не пришло

        val deteilImage = findViewById<ImageView>(R.id.detailIMG)
        val detailName = findViewById<TextView>(R.id.detailName)
        val detailPryse = findViewById<TextView>(R.id.detailPryse)
        val detailDescription = findViewById<TextView>(R.id.detailDescription)
        val buybtn = findViewById<Button>(R.id.buybtn)
        val bekbtn = findViewById<Button>(R.id.bekbtn)
        val favoriteBtn = findViewById<Button>(R.id.favoritebtn)

        deteilImage.setImageResource(productImageRes)
        detailName.text = productName
        detailPryse.text = "$productPrice ₽"
        detailDescription.text = productdescription

        deteilImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        detailName.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        detailPryse.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        detailDescription.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        buybtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        bekbtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        favoriteBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))

        buybtn.setOnClickListener {
            val one_new_product = Produkt(
                id = productId,
                name = productName,
                price = productPrice,
                productdescription,
                ImageRes = productImageRes)

            CartStorage.add_item(this, one_new_product)

            Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_SHORT).show()
        }
        buybtn.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_down))
            }
            if (event.action == MotionEvent.ACTION_UP){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            if (event.action == MotionEvent.ACTION_CANCEL){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            false
        }

        bekbtn.setOnClickListener {
            finish()
        }
        bekbtn.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_down))
            }
            if (event.action == MotionEvent.ACTION_UP){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            if (event.action == MotionEvent.ACTION_CANCEL){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            false
        }

        favoriteBtn.setOnClickListener {
            val one_new_product = Produkt(
                id = productId,
                name = productName,
                price = productPrice,
                productdescription,
                ImageRes = productImageRes)

            val added = FavoriteStorage.add_item(this, one_new_product)

            if (added == true) {
                Toast.makeText(this, "Товар добавлен в избранное", Toast.LENGTH_SHORT).show()
            }
            if (added == false){
                Toast.makeText(this, "Товар добавлен ранее", Toast.LENGTH_SHORT).show()
            }
        }
        favoriteBtn.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_down))
            }
            if (event.action == MotionEvent.ACTION_UP){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            if (event.action == MotionEvent.ACTION_CANCEL){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            false
        }
    }
}