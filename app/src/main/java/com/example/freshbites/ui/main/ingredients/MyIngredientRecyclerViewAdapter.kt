package com.example.freshbites.ui.main.ingredients

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.freshbites.R
import com.example.freshbites.ui.main.ingredients.IngredientData
import com.example.freshbites.databinding.IngredientListItemBinding

/**
 * [RecyclerView.Adapter] that can display a [IngredientData].
 * TODO: Replace the implementation with code for your data type.
 */
class MyIngredientRecyclerViewAdapter(private val ingredients: List<IngredientData>, private val checkerOnClick: (CardView) -> Unit
) :
    RecyclerView.Adapter<MyIngredientRecyclerViewAdapter.IngredientViewHolder>() {

    // Create an inner class for RecipeViewHolder. We pass the binding to the constructor of the ViewHolder.
    inner class IngredientViewHolder(val binding: IngredientListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {

        return IngredientViewHolder(
            IngredientListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val item = ingredients[position]
        val checked = item.checked
        holder.binding.IngredientCard.setOnClickListener {
            checkerOnClick(it as CardView)
        }
        holder.binding.ingredientItemText.text = item.name
        if (checked)
        {
            holder.binding.IngredientCard.setCardBackgroundColor(
                ContextCompat.getColor(holder.binding.root.context, R.color.green_Have_Ingredient))
        }
        else
        {
            holder.binding.IngredientCard.setCardBackgroundColor(
                ContextCompat.getColor(holder.binding.root.context, R.color.red_No_Ingredient))
        }
    }



}