package com.red_velvet.yumhub.data.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class RandomRecipesDto(
    @SerializedName("recipes")
    val recipes: List<RecipeInformationDto>? = listOf()
)