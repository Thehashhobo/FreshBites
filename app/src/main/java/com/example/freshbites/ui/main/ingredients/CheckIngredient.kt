package com.example.freshbites.ui.main.ingredients

import kotlin.random.Random

class CheckIngredient(val ingredients: ArrayList<String>?) {
    fun convertToIngredientData(): ArrayList<IngredientData>{
        /**
         * access database to check status of ingredient data
         */
        val returnArraylist = ArrayList<IngredientData>()
        if (ingredients != null) {
            for (item in ingredients){
                returnArraylist.add(IngredientData(Random.nextBoolean(), item))
            }
        }
        return returnArraylist

    }
}