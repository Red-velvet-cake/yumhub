package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.CaloriesDto
import com.red_velvet.yumhub.data.remote.dtos.ConfidenceRange95PercentDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.domain.models.recipes.Calories
import com.red_velvet.yumhub.domain.models.recipes.ConfidenceRange95Percent
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun GuessNutritionDto.toModel(): GuessNutrition {
    return GuessNutrition(
        calories = caloriesDto?.toModel() ?: Calories(),
        carbs = carbs?.toModel() ?: Calories(),
        fat = fat?.toModel() ?: Calories(),
        protein = protein?.toModel() ?: Calories(),
        recipesUsed = recipesUsed.orZero()
    )
}

fun CaloriesDto.toModel(): Calories {
    return Calories(
        confidenceRange95Percent = confidenceRange95Percent?.toModel(),
        value = value.orZero(),
        unit = unit.orEmpty()
    )
}

fun ConfidenceRange95PercentDto.toModel(): ConfidenceRange95Percent {
    return ConfidenceRange95Percent(
        max = this.max.orZero(),
        min = this.min.orZero()
    )
}