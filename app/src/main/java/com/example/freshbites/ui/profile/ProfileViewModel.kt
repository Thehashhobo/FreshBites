package com.example.freshbites.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.freshbites.recyclerHome.Items
import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardData

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is profile Fragment"
    }


    private val _recipes = MutableLiveData<List<RecipeCardData>>()
    val recipes: LiveData<List<RecipeCardData>> = _recipes
    private val ingredients = ArrayList<String>(3)

    init {
        _text.value = ""
        ingredients.add("beef")
        ingredients.add("carrot")
        ingredients.add("chicken stock")
        // Create sample data for the Recipes
        val sampleRecipes = listOf(
            RecipeCardData(
                "Pickled Pepper anasdvsd  asd fasdas Onion Relishasdxav",
                1.toFloat(),
                "1 hrs 45 min",
                "temp",
                "Overview",
                "instuctions placeholdersd oknldsaknf;lkadsnfl;dkf",
                ingredients
            ),
            RecipeCardData(
                "t2",
                4.5.toFloat(),
                "2.5 hour",
                "temp",
                "Overview",
                "instuctions placeholdersd oknldsaknf;lkadsnfl;dkf",
                ingredients
            ),
            RecipeCardData(
                "t3",
                4.9.toFloat(),
                "1 hour",
                "temp",
                "Overview",
                "instuctions placeholdersd oknldsaknf;lkadsnfl;dkf",
                ingredients
            ),
            RecipeCardData(
                "Pickled Pepper anasdvsd  asd fasdas Onion Relishasdxav",
                1.toFloat(),
                "1 hrs 45 min",
                "temp",
                "Overview",
                "instuctions placeholdersd oknldsaknf;lkadsnfl;dkf",
                ingredients
            ),
            RecipeCardData(
                "t2",
                4.5.toFloat(),
                "2.5 hour",
                "temp",
                "Overview",
                "instuctions placeholdersd oknldsaknf;lkadsnfl;dkf",
                ingredients
            ),
            RecipeCardData(
                "t3",
                4.9.toFloat(),
                "1 hour",
                "temp",
                "Overview",
                "instuctions placeholdersd oknldsaknf;lkadsnfl;dkf",
                ingredients
            )
        )
        if (sampleRecipes == null || sampleRecipes.isEmpty()){
            _text.value = "You don't have any saved recipes yet, but When you do, they will be right here !"
        //not tested

        } else {
            _recipes.value = sampleRecipes
        }

    }



    val text: LiveData<String> = _text
}