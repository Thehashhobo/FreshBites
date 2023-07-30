package com.example.freshbites.recyclerHome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.freshbites.databinding.ItemCardBinding
import com.example.freshbites.databinding.ItemRecyclerBinding
import com.example.freshbites.databinding.ItemTextBinding
import com.example.freshbites.R
import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardAdapter


class ItemAdapter(var items: List<Items>) : RecyclerView.Adapter<ItemViewHolder>() {
    var viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    @JvmName("setItemsList")
    fun setItems(newItems: List<Items>) {
        items = newItems
        notifyDataSetChanged() // Notify the adapter that the dataset has changed
    }


    override fun getItemViewType(position: Int): Int {
        return when (val item = items[position]) {
            is Items.CardItem -> 0
            is Items.TextItem -> 1
            is Items.RecyclerViewItem -> 2
            else -> {
                -1
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                val binding = ItemCardBinding.inflate(inflater, parent, false)
                ItemViewHolder.CardViewHolder(binding)
            }

            1 -> {
                val binding = ItemTextBinding.inflate(inflater, parent, false)
                ItemViewHolder.TextViewHolder(binding)
            }

            else -> {
                val binding = ItemRecyclerBinding.inflate(inflater, parent, false)
                ItemViewHolder.RecyclerViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        if (item is Items.CardItem && holder is ItemViewHolder.CardViewHolder) {
            holder.binding.recipeCardTextTitle.text = item.title
            holder.binding.recipeActualImage.setBackgroundResource(R.drawable.test_image2)
            holder.binding.recipeCardTextTime.text = item.time
            holder.binding.recipeCardRatingBar.rating = item.rating

        } else if (item is Items.TextItem && holder is ItemViewHolder.TextViewHolder) {
            holder.binding.itemTV.text = item.title

        } else if (item is Items.RecyclerViewItem && holder is ItemViewHolder.RecyclerViewHolder) {
            val item: Items.RecyclerViewItem = items[position] as Items.RecyclerViewItem

            var layoutManager: LinearLayoutManager = LinearLayoutManager(
                holder.binding.root.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            layoutManager.initialPrefetchItemCount = item.subItemsList.size;
            val subItemAdapter = RecipeCardAdapter(item.subItemsList)
            holder.binding.itemRV.layoutManager = layoutManager
            holder.binding.itemRV.adapter = subItemAdapter
            holder.binding.itemRV.setRecycledViewPool(viewPool)



        }


    }
}




