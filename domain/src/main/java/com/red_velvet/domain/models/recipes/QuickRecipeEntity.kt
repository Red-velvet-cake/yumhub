package com.red_velvet.domain.models.recipes


data class QuickRecipeEntity(
    val id: Int = 0,
    val title: String = "",
    val image: String = "",
    val cookingMinutes: Int = 0
)
