package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.models.recipes.CaloriesEntity
import com.red_velvet.yumhub.domain.models.recipes.ConfidenceRange95PercentEntity
import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.recipe.GuessNutritionDto

fun GuessNutritionDto.toEntity(): GuessNutritionEntity {
    return GuessNutritionEntity(
        caloriesEntity = caloriesDto?.toModel() ?: CaloriesEntity(),
        carbs = carbs?.toModel() ?: CaloriesEntity(),
        fat = fat?.toModel() ?: CaloriesEntity(),
        protein = protein?.toModel() ?: CaloriesEntity(),
        recipesUsed = recipesUsed.orZero()
    )
}

fun com.red_velvet.yumhub.remote.resources.CaloriesDto.toModel(): CaloriesEntity {
    return CaloriesEntity(
        confidenceRange95PercentEntity = confidenceRange95Percent?.toModel(),
        value = value.orZero(),
        unit = unit.orEmpty()
    )
}

fun com.red_velvet.yumhub.remote.resources.ConfidenceRange95PercentDto.toModel(): ConfidenceRange95PercentEntity {
    return ConfidenceRange95PercentEntity(
        max = this.max.orZero(),
        min = this.min.orZero()
    )
}