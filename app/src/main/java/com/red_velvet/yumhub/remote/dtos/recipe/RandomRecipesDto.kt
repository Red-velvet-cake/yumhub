package com.red_velvet.yumhub.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class RandomRecipesDto(
    @SerializedName("recipes")
    val recipes: List<com.red_velvet.yumhub.remote.dtos.recipe.RecipeInformationDto>? = listOf()
)