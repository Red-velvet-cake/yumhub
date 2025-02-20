package com.red_velvet.yumhub.domain.models.recipes


data class SimilarRecipeEntity(
    val id: Int,
    val imageType: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val title: String
)
