package com.red_velvet.yumhub.domain.models.recipes

data class RecipeEntity(
    val id: Int = 0,
    val title: String = "",
    val imageUrl: String = "",
    val overview: String = ""
)
