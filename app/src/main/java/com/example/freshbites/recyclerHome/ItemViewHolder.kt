package com.example.freshbites.recyclerHome

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.freshbites.databinding.ItemCardBinding
import com.example.freshbites.databinding.ItemRecyclerBinding
import com.example.freshbites.databinding.ItemTextBinding

sealed class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class CardViewHolder(val binding: ItemCardBinding) : ItemViewHolder(binding.root)
    class TextViewHolder(val binding: ItemTextBinding) : ItemViewHolder(binding.root)
    class RecyclerViewHolder(val binding: ItemRecyclerBinding) : ItemViewHolder(binding.root)
}