package com.red_velvet.yumhub.domain.models.recipes


data class GuessNutrition(
    val calories: Nutrient,
    val carbs: Nutrient,
    val fat: Nutrient,
    val protein: Nutrient,
    val recipesUsed: Int
)
