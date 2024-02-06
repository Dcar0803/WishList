package com.example.wishlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var items: MutableList<WishListItem>
    private lateinit var adapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = mutableListOf() // Initialize an empty list of wishlist items

        val emailsRv = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = WishlistAdapter(items)
        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        val btnAddItem = findViewById<Button>(R.id.btnAddItem)
        btnAddItem.setOnClickListener {
            addItemToWishlist()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addItemToWishlist() {
        val editName = findViewById<EditText>(R.id.editName)
        val editPrice = findViewById<EditText>(R.id.editPrice)
        val editURL = findViewById<EditText>(R.id.editURL)

        val name = editName.text.toString()
        val price = editPrice.text.toString()
        val url = editURL.text.toString()

        if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {
            val newItem = WishListItem(name, price, url)
            items.add(newItem)
            adapter.notifyDataSetChanged()
            clearEditTexts()
        }
    }

    private fun clearEditTexts() {
        val editName = findViewById<EditText>(R.id.editName)
        val editPrice = findViewById<EditText>(R.id.editPrice)
        val editURL = findViewById<EditText>(R.id.editURL)

        editName.text.clear()
        editPrice.text.clear()
        editURL.text.clear()
    }
}
