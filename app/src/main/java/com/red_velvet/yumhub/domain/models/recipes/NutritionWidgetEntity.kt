package com.red_velvet.yumhub.domain.models.recipes



data class NutritionWidgetEntity(
    val bad: List<NutritionalInfoEntity>,
    val good: List<NutritionalInfoEntity>
)

