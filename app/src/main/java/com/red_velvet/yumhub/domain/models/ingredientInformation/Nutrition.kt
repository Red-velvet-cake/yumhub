package com.red_velvet.yumhub.domain.models.ingredientInformation


data class Nutrition(
    val nutrients : List<Nutrients>?,
    val properties: List<Property>?,
    val weightPerServing: WeightPerServing
)
