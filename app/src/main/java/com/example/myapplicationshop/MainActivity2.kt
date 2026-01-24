package com.example.myapplicationshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import Produkt
import android.content.Intent
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar


private val products = listOf(
    Produkt(id=1, name="Франшиза1", price = 5000000.0, ImageRes =R.drawable.one ),
    Produkt(id=2, name="Франшиза2", price = 8500000.0, ImageRes =R.drawable.two ),
    Produkt(id=3, name="Франшиза3", price = 6000000.0, ImageRes =R.drawable.thre ),
    Produkt(id=4, name="Франшиза4", price = 2000000.0, ImageRes =R.drawable.four ),
    Produkt(id=5, name="Франшиза5", price = 2500000.0, ImageRes =R.drawable.five ),
)

class MainActivity2 : AppCompatActivity() {
    private lateinit var lvList: ListView
    private lateinit var rvGrid: RecyclerView
    private lateinit var listAdapter: ProductAdapter
    private lateinit var gridAdapter: ProductGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sek)

        val toolBar = findViewById<MaterialToolbar>(R.id.topBar)
        setSupportActionBar(toolBar)

        lvList = findViewById(R.id.lvCatalog)
        rvGrid = findViewById(R.id.rvCatalogGrid)

        listAdapter = ProductAdapter(this, products)

        gridAdapter = ProductGridAdapter(this, products)

        lvList.adapter = listAdapter

        rvGrid.layoutManager = GridLayoutManager(this, 2)
        rvGrid.adapter = gridAdapter
    }

    private fun showList() {
        lvList.visibility = View.VISIBLE
        rvGrid.visibility = View.GONE
    }

    private fun showGrid() {
        lvList.visibility = View.GONE
        rvGrid.visibility = View.VISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_second, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_list) {
            showList()
            return true
        }
        if (item.itemId == R.id.action_Grid) {
            showGrid()
            return true
        }

        return super.onOptionsItemSelected(item)


    }


//        val container = findViewById<ListView>(R.id.lvCatalog)
//
//        val adapter = ProductAdapter(this, products )
//
//        container.adapter = adapter


//    val container = findViewById<LinearLayout>(R.id.Catalog)
//
//        products.forEach{ produkt ->
//            val view = layoutInflater.inflate(R.layout.item_product,container, false)
//
//            view.findViewById<ImageView>(R.id.ivProductImage).setImageResource(produkt.ImageRes)
//            view.findViewById<TextView>(R.id.tvProductName).text = produkt.name
//            view.findViewById<TextView>(R.id.tvProductPrise).text = "${produkt.price} ₽"
//
//            view.findViewById<Button>(R.id.btnDetails).setOnClickListener {
//                val intent = Intent(this,
//                DeteilActivity::class.java).apply {
//                    putExtra("name", produkt.name)
//                    putExtra("price", produkt.price)
//                    putExtra("ImageRes", produkt.ImageRes)
//                    putExtra("description", produkt.description)
//
//                }
//                startActivity(intent)
//            }
//
//            container.addView(view)
//        }


    }



class ProductAdapter(
    private val context: android.content.Context,
    private val products: List<Produkt>
) : android.widget.BaseAdapter() {

    override fun getCount() = products.size

    override fun getItem(position: Int) = products[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View? {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_product, parent, false)

        val produkt = getItem(pos)

        val image = view.findViewById<ImageView>(R.id.ivProductImage)
        val name = view.findViewById<TextView>(R.id.tvProductName)
        val prise = view.findViewById<TextView>(R.id.tvProductPrise)
        val button = view.findViewById<Button>(R.id.btnDetails)

        image.setImageResource(produkt.ImageRes)
        name.text = produkt.name
        prise.text = "${produkt.price} ₽"

        button.setOnClickListener {
            val intent = Intent(
                context,
                DeteilActivity::class.java
            ).apply {
                putExtra("name", produkt.name)
                putExtra("price", produkt.price)
                putExtra("ImageRes", produkt.ImageRes)
                putExtra("description", produkt.description)

            }
            context.startActivity(intent)
        }
        return view
    }
}
