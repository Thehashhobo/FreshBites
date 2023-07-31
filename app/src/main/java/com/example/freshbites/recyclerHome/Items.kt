package com.example.freshbites.recyclerHome

import android.os.Parcelable
import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardData

sealed class Items {
    data class CardItem(val cardData: RecipeCardData) : Items()

    data class TextItem(val title: String) : Items()

    data class RecyclerViewItem(val subItemsList: List<RecipeCardData>) : Items()

}