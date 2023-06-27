package com.red_velvet.yumhub.ui.test_your_meal

import com.red_velvet.yumhub.domain.models.recipes.NutritionalInfoEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.utils.orZero

fun NutritionalInfoEntity.toUiState(): TestYourMealResultUiState {
    return TestYourMealResultUiState(
        amount = amount.orEmpty(),
        indented = indented.orFalse(),
        name = name.orEmpty(),
        DailyNeeds = percentOfDailyNeeds.orZero()
    )
}