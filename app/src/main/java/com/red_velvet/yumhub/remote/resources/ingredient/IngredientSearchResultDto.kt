package com.red_velvet.yumhub.remote.resources.ingredient


import com.google.gson.annotations.SerializedName

data class IngredientSearchResultDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("name")
    val name: String? = null
)