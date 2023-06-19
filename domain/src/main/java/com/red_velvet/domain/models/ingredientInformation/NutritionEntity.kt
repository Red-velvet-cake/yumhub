package com.red_velvet.domain.models.ingredientInformation


data class NutritionEntity(
    val nutrients: List<NutrientsEntity>?,
    val properties: List<PropertyEntity>?,
    val weightPerServingEntity: WeightPerServingEntity
)
