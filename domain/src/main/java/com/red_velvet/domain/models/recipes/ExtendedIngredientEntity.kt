package com.red_velvet.domain.models.recipes


data class ExtendedIngredientEntity(
    val aisle: String,
    val amount: Double,
    val id: Int,
    val image: String,
    val name: String,
    val unit: String
)
