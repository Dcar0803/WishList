// WishlistAdapter.kt
package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val items: List<WishListItem>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textPrice: TextView = itemView.findViewById(R.id.textPrice)
        val textURL: TextView = itemView.findViewById(R.id.textURL)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.textName.text = currentItem.name
        holder.textPrice.text = currentItem.price
        holder.textURL.text = currentItem.url
    }

    override fun getItemCount() = items.size
}
