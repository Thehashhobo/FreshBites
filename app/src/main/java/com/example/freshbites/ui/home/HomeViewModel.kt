package com.example.freshbites.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.freshbites.recyclerHome.Items
import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardData

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _recipes = MutableLiveData<List<RecipeCardData>>()
    val recipes: LiveData<List<RecipeCardData>> = _recipes
    private val _items = MutableLiveData<List<Items>>()
    val items: LiveData<List<Items>> = _items
    private val ingredients = ArrayList<String>(3)

    init {
        _text.value = "Home Fragment"
        ingredients.add("asfqjbwne")
        ingredients.add("ASDSADAS")
        ingredients.add("asfqZXVXjbwne")
        // Create sample data for the Recipes
        val sampleRecipes = listOf(
            RecipeCardData("Pickled Pepper anasdvsd  asd fasdas Onion Relishasdxav", 1.toFloat(), "1 hrs 45 min", "temp","Overview","instuctions placeholdersd oknldsaknf;lkadsnfl;dkf", ingredients),
            RecipeCardData("t2", 4.5.toFloat(), "2.5 hour", "temp", "Overview","instuctions placeholdersd oknldsaknf;lkadsnfl;dkf", ingredients),
            RecipeCardData("t3", 4.9.toFloat(), "1 hour", "temp","Overview","instuctions placeholdersd oknldsaknf;lkadsnfl;dkf", ingredients),
            RecipeCardData("Pickled Pepper anasdvsd  asd fasdas Onion Relishasdxav", 1.toFloat(), "1 hrs 45 min", "temp","Overview","instuctions placeholdersd oknldsaknf;lkadsnfl;dkf", ingredients),
            RecipeCardData("t2", 4.5.toFloat(), "2.5 hour", "temp", "Overview","instuctions placeholdersd oknldsaknf;lkadsnfl;dkf", ingredients),
            RecipeCardData("t3", 4.9.toFloat(), "1 hour", "temp","Overview","instuctions placeholdersd oknldsaknf;lkadsnfl;dkf", ingredients)
        )
        val sampleItems = listOf<Items>(
            Items.CardItem("c1", 4.5.toFloat(), "2.5 hour", "temp"),
            Items.CardItem("c2", 4.5.toFloat(), "1 hrs 45 min", "temp"),
            Items.TextItem("text 1"),
            Items.RecyclerViewItem(sampleRecipes),
            Items.TextItem("text 2"),
            Items.RecyclerViewItem(sampleRecipes),
            Items.TextItem("text 3"),
            Items.RecyclerViewItem(sampleRecipes)

        )

        _items.value = sampleItems
    }
}