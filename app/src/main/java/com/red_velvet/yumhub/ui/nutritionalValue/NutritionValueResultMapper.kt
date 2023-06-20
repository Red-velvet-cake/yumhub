package com.red_velvet.yumhub.ui.nutritionalValue

import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.ui.search.SearchResultUIState

fun GuessNutritionEntity.toNutritionalValueResultUIState(): NutritionalValueResultUIState {
    return NutritionalValueResultUIState(
        calories = caloriesEntity.value.orZero(),
        carbs = carbs.value.orZero(),
        fat = fat.value.orZero(),
        protein = protein.value.orZero(),
    )
}