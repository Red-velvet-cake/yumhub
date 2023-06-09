package com.red_velvet.yumhub.data.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class RecipeSearchDto(
    @SerializedName("number")
    val number: Int? = 0,
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("results")
    val results: List<RecipeInformationDto>? = listOf(),
    @SerializedName("totalResults")
    val totalResults: Int? = 0
)