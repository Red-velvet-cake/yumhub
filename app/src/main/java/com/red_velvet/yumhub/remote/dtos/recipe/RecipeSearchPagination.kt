package com.red_velvet.yumhub.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class RecipeSearchPagination(
    @SerializedName("number")
    val number: Int? = 0,
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("results")
    val results: List<RecipeSearchResultResource>? = listOf(),
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)