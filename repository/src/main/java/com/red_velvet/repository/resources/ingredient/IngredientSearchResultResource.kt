package com.red_velvet.repository.resources.ingredient


import com.google.gson.annotations.SerializedName

data class IngredientSearchResultResource(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("name")
    val name: String? = null
)