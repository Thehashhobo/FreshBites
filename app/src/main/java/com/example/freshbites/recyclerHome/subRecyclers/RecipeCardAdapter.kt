package com.example.freshbites.recyclerHome.subRecyclers

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshbites.R
import com.example.freshbites.RecipeActivity
import com.example.freshbites.databinding.RecipeCardBinding
import com.example.freshbites.recyclerHome.Items


class RecipeCardAdapter(var cards: List<RecipeCardData>)
    : RecyclerView.Adapter<RecipeCardAdapter.RecipeViewHolder>() {

    private lateinit var mlistner: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    @JvmName("setCardsList")
    fun setCards(newCards: List<RecipeCardData>) {
        cards = newCards
        notifyDataSetChanged() // Notify the adapter that the dataset has changed
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mlistner = listener
    }

    // Create an inner class for RecipeViewHolder. We pass the binding to the constructor of the ViewHolder.
    inner class RecipeViewHolder(val binding: RecipeCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        // Inflate the binding based on the layout XML file.
        val binding = RecipeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.recipeCardTextTitle.text = cards[position].title
        holder.binding.recipeActualImage.setBackgroundResource(R.drawable.test_image)
        holder.binding.recipeCardTextTime.text = cards[position].time
        holder.binding.recipeCardRatingBar.rating = cards[position].rating
        val intent = Intent(holder.binding.root.context, RecipeActivity::class.java)
        val recipeCardData = cards[position]
        intent.putExtra("passed_data", recipeCardData)
        holder.binding.button.setOnClickListener {holder.binding.root.context.startActivity(intent)}
        // place holder


    }
}

//private fun Intent.putExtra(s: String, recipeCardData: RecipeCardData) {
//
//}

//refer to "RECYCLERVIEW - Android Fundamentals" and use synthetic if this fails.