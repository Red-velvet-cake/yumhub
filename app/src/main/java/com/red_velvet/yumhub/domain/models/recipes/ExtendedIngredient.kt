package com.red_velvet.yumhub.domain.models.recipes

import com.red_velvet.yumhub.data.remote.dtos.MeasuresDto

data class ExtendedIngredient(
    val aisle: String,
    val amount: Double,
    val id: Int,
    val image: String,
    val measures: MeasuresDto,
    val name: String,
    val unit: String
)
