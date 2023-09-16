package com.red_velvet.yumhub.domain.models

data class PlannedMealEntity(
    val id: Int,
    val slot: Int,
    val title: String,
    val imageUrl: String,
    val description: String
)
