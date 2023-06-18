package com.red_velvet.yumhub.domain.models.ingredientInformation


data class NutritionEntity(
    val nutrients: List<NutrientsEntity>?,
    val properties: List<PropertyEntity>?,
    val weightPerServingEntity: WeightPerServingEntity
)
