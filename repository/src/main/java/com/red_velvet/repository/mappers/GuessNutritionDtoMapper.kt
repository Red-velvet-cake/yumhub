package com.red_velvet.repository.mappers


import com.red_velvet.domain.models.recipes.CaloriesEntity
import com.red_velvet.domain.models.recipes.ConfidenceRange95PercentEntity
import com.red_velvet.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.repository.resources.CaloriesResource
import com.red_velvet.repository.resources.ConfidenceRange95PercentResource
import com.red_velvet.repository.resources.recipe.GuessNutritionResource
import com.red_velvet.repository.utils.orZero


internal fun GuessNutritionResource.toEntity(): GuessNutritionEntity {
    return GuessNutritionEntity(
        caloriesEntity = caloriesResource?.toModel()
            ?: CaloriesEntity(),
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