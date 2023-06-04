package com.red_velvet.yumhub.domain.models.recipes



data class Step(
    val equipment: List<Equipment>,
    val length: Length,
    val number: Int,
    val step: String
)
