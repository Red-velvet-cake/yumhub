package com.red_velvet.yumhub.domain.models.recipes


data class GuessNutrition(
    val calories: Calories,
    val carbs: Calories,
    val fat: Calories,
    val protein: Calories,
    val recipesUsed: Int
)
