package com.red_velvet.yumhub.domain.models.recipes



data class Step(
    val equipment: List<Equipment>? = emptyList(),
    val length: Length? = null,
    val number: Int?,
    val step: String?
)
