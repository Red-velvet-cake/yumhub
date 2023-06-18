package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.CaloriesEntity
import com.red_velvet.yumhub.domain.models.recipes.ConfidenceRange95PercentEntity
import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.CaloriesResource
import com.red_velvet.yumhub.remote.resources.ConfidenceRange95PercentResource
import com.red_velvet.yumhub.remote.resources.recipe.GuessNutritionResource

fun GuessNutritionResource.toEntity(): GuessNutritionEntity {
    return GuessNutritionEntity(
        caloriesEntity = caloriesResource?.toModel() ?: CaloriesEntity(),
        carbs = carbs?.toModel() ?: CaloriesEntity(),
        fat = fat?.toModel() ?: CaloriesEntity(),
        protein = protein?.toModel() ?: CaloriesEntity(),
        recipesUsed = recipesUsed.orZero()
    )
}

fun CaloriesResource.toModel(): CaloriesEntity {
    return CaloriesEntity(
        confidenceRange95PercentEntity = confidenceRange95Percent?.toModel(),
        value = value.orZero(),
        unit = unit.orEmpty()
    )
}

fun ConfidenceRange95PercentResource.toModel(): ConfidenceRange95PercentEntity {
    return ConfidenceRange95PercentEntity(
        max = this.max.orZero(),
        min = this.min.orZero()
    )
}