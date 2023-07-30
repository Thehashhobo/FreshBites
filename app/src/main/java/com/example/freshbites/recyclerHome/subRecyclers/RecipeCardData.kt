package com.example.freshbites.recyclerHome.subRecyclers

import android.os.Parcel
import android.os.Parcelable

data class RecipeCardData(
    val title: String,
    val rating: Float,
    val time: String,
    val image_url: String,
    val overview: String,
    val instructions: String,
    val ingredient: ArrayList<String>

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readString() ?: "30 min",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createStringArrayList() as ArrayList<String>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeFloat(rating)
        parcel.writeString(time)
        parcel.writeString(image_url)
        parcel.writeString(overview)
        parcel.writeString(instructions)
        parcel.writeStringList(ingredient)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecipeCardData> {
        override fun createFromParcel(parcel: Parcel): RecipeCardData {
            return RecipeCardData(parcel)
        }

        override fun newArray(size: Int): Array<RecipeCardData?> {
            return arrayOfNulls(size)
        }
    }

}