package com.red_velvet.yumhub.remote.resources.ingredient


import com.google.gson.annotations.SerializedName

data class IngredientSearchResource(
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("results")
    val results: List<com.red_velvet.yumhub.remote.resources.ingredient.IngredientSearchResultResource>? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)