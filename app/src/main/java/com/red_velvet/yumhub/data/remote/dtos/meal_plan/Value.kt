package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("imageType")
    val imageType: String? = null,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient?>? = null,
    @SerializedName("servings")
    val servings: Int? = null,
    @SerializedName("title")
    val title: String? = null
)