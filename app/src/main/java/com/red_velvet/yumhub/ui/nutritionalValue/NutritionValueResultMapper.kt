package com.red_velvet.yumhub.ui.nutritionalValue
import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.utils.orZero

fun GuessNutritionEntity.toNutritionalValueResultUIState(): NutritionalValueResultUIState {
    return NutritionalValueResultUIState(
        calories = caloriesEntity.value.orZero(),
        carbs = carbs.value.orZero(),
        fat = fat.value.orZero(),
        protein = protein.value.orZero(),
    )
}