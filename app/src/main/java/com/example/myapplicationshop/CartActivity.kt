package com.example.myapplicationshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.model.CartStorage
import com.example.myapplicationshop.model.HistoryStorage
import com.example.myapplicationshop.model.Order
import java.util.Date
import java.util.Locale.getDefault

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)

        val rv = findViewById<RecyclerView>(R.id.rvCartList)
        val tvTotak = findViewById<TextView>(R.id.tvCartTotalSumm)
        val btnClear = findViewById<Button>(R.id.btnClearCart)
        val btnMakeOrder = findViewById<Button>(R.id.btnMakeOrder)
        val btnOpenHistory = findViewById<Button>(R.id.btnOpenHistory)

        val items = CartStorage.all()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = CartAdapter(items)


        var total = 0.0
        for (elem in items){
            total += elem.price
        }
        tvTotak.text = "Итого: ${total} ₽"
        btnClear.setOnClickListener {
            CartStorage.clear(this)
            rv.adapter = CartAdapter(emptyList())
            tvTotak.text = "Итого: 0 "
        }

        btnOpenHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        btnMakeOrder.setOnClickListener {
            val cartitems = CartStorage.all() // получение всех товаров cart
            if (cartitems.isEmpty()){  // if пусто ничего не делаем
                return@setOnClickListener
            }

            val formatter = java.text.SimpleDateFormat("dd.MM.yyyy HH:mm", getDefault())
            val dateTime = formatter.format(Date())

            var purchases = mutableListOf<Order>()
            for (elem in cartitems){
                var found = false // нашёлся товар или нет

                for (i in purchases.indices){
                    if (elem.id == purchases[i].product.id){
                        // + кол-во
                        var old = purchases[i]
                        purchases[i] = Order(old.product, old.dateTime, old.quantity + 1, old.product.price * (old.quantity + 1))

                        found = true
                        break
                    }

                }
                    // если товара нет
                if (found == false){
                    purchases.add(Order(elem, dateTime, 1,elem.price * 1))
                }
            }

            HistoryStorage.add_all(this, purchases)

            CartStorage.clear(this)

            rv.adapter = CartAdapter(emptyList())
            tvTotak.text = "Итого: 0.0 ₽"
        }
    }
}