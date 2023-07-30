package com.example.freshbites.recyclerHome

import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardData

sealed class Items {
    data class CardItem(val title: String,
                        val rating: Float,
                        val time: String,
                        val url: String) : Items()

    data class TextItem(val title: String) : Items()

    data class RecyclerViewItem(val subItemsList: List<RecipeCardData>) : Items()

}