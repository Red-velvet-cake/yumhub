package com.red_velvet.yumhub.domain.models.recipes


data class GuessNutritionEntity(
    val caloriesEntity: CaloriesEntity,
    val carbs: CaloriesEntity,
    val fat: CaloriesEntity,
    val protein: CaloriesEntity,
    val recipesUsed: Int
)
