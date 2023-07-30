package com.example.freshbites.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.freshbites.R
import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardData
import com.example.freshbites.ui.main.ingredients.IngredientsFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class RecipesAdapter(private val context: Context, fm: FragmentManager, lifecycle: Lifecycle, private val recipeData: RecipeCardData) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val recipeOverviewData = ArrayList<String>()
        recipeOverviewData.add(recipeData.title)
        recipeOverviewData.add(recipeData.time)
        recipeOverviewData.add(recipeData.rating.toString())
        recipeOverviewData.add(recipeData.image_url)
        recipeOverviewData.add(recipeData.overview)
        return when(position){
                0 -> OverviewFragment().apply {
                    arguments = Bundle().apply {
                        putStringArrayList("recipeOverviewData", recipeOverviewData)
                    }
                }
            1 -> IngredientsFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList("recipeIngredientData", recipeData.ingredient)
                }
            }
            2 -> InstructionsFragment().apply {
                arguments = Bundle().apply {
                    putString("recipeInstructionsData", recipeData.instructions)
                }
            }
            else -> {OverviewFragment()}
        }
//        return when (position) {
//            0 -> OverviewFragment()
//            1 -> IngredientsFragment()
//            else -> InstructionsFragment()
//        }
    }
}