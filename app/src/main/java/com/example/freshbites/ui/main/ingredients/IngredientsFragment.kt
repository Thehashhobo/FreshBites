package com.example.freshbites.ui.main.ingredients

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshbites.R
import com.example.freshbites.databinding.TabIngredientsFragmentBinding
import com.google.android.material.snackbar.Snackbar


class IngredientsFragment : Fragment() {
    private var _binding: TabIngredientsFragmentBinding? = null
    private val binding get() = _binding!!
    fun sortByStatus(ingredients: List<IngredientData>): List<IngredientData> {
        return ingredients.sortedWith(compareBy({ !it.checked }, { it.name }))
    }
    private fun checkerOnclick(view: CardView){
        val text = view.findViewById<TextView>(R.id.ingredient_item_text).text
        val cardViewColor = (view.cardBackgroundColor).defaultColor
        val green = ContextCompat.getColor(requireContext(), R.color.green_Have_Ingredient)
        val red = ContextCompat.getColor(requireContext(), R.color.red_No_Ingredient)
        if (cardViewColor == green){
            view.setCardBackgroundColor(red)
            val returnText = "$text removed from inventory"
            Snackbar.make(view, returnText, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        } else {
            view.setCardBackgroundColor(green)
            val returnText = "$text added to inventory"
            Snackbar.make(view, returnText, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        _binding = TabIngredientsFragmentBinding.inflate(inflater, container,false)
        val root: View = binding.root
        val recipeIngredientData = arguments?.getStringArrayList("recipeIngredientData")
        val ingredientAdapter = MyIngredientRecyclerViewAdapter(sortByStatus(CheckIngredient(recipeIngredientData).convertToIngredientData()), ::checkerOnclick)

        binding.ingredientsRV.adapter = ingredientAdapter
        binding.ingredientsRV.layoutManager  = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

