package com.red_velvet.yumhub.ui.nutrition_info

import com.red_velvet.yumhub.domain.models.recipes.NutritionalInfoEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.utils.orZero


fun NutritionalInfoEntity.toUiState(): NutritionInfoUiState.NutritionInfoResultUiState {
    return NutritionInfoUiState.NutritionInfoResultUiState(
        amount = amount.orEmpty(),
        indented = indented.orFalse(),
        name = name.orEmpty(),
        DailyNeeds = percentOfDailyNeeds.orZero()
    )
}
fun List<NutritionalInfoEntity>.toUiState(): List<NutritionInfoUiState.NutritionInfoResultUiState> {
    return map { it.toUiState() }
}