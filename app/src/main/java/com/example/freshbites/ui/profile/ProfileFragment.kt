package com.example.freshbites.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshbites.RecipeActivity
import com.example.freshbites.databinding.FragmentProfileBinding
import com.example.freshbites.recyclerHome.ItemAdapter
import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardAdapter
import com.example.freshbites.ui.main.ingredients.IngredientsFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val profileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recipeCardAdapter = RecipeCardAdapter(listOf())
        binding.porfileRV.adapter = recipeCardAdapter // assign the adapter to your RecyclerView
        binding.porfileRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) // assuming you want a vertical list of items

        val textView: TextView = binding.noSavedText
        profileViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        profileViewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            recipeCardAdapter.setCards(recipes)
            recipeCardAdapter.notifyDataSetChanged()

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}