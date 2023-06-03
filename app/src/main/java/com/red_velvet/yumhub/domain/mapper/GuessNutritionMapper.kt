package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import com.red_velvet.yumhub.domain.models.recipes.Nutrient

fun GuessNutritionDto.toModel(): GuessNutrition {
    return GuessNutrition(
        calories = this.calories as Nutrient,
        carbs = this.carbs as Nutrient,
        fat = this.fat as Nutrient,
        protein = this.protein as Nutrient,
        recipesUsed = this.recipesUsed ?: 0
    )
}