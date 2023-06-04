package com.red_velvet.yumhub.data.remote.dtos.ingredient


import com.google.gson.annotations.SerializedName

data class IngredientSearchDto(
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("results")
    val results: List<IngredientSearchResultDto>? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)