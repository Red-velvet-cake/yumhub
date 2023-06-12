package com.red_velvet.yumhub.remote.resources.recipe


import com.google.gson.annotations.SerializedName

data class RandomRecipesResource(
    @SerializedName("recipes")
    val recipes: List<com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource>? = listOf()
)