package com.red_velvet.yumhub.domain.models.recipes


data class Calories(
    val confidenceRange95Percent: ConfidenceRange95Percent? = null,
    val unit: String? = null,
    val value: Double? = null
)
