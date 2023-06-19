package com.red_velvet.repository.resources.recipe


import com.google.gson.annotations.SerializedName

data class RecipeSearchPaginationResource(
    @SerializedName("number")
    val number: Int? = 0,
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("results")
    val results: List<com.red_velvet.repository.resources.recipe.RecipeInformationResource>? = listOf(),
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)