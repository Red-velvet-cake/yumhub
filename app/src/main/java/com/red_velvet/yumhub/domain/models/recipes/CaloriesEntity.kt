package com.red_velvet.yumhub.domain.models.recipes


data class CaloriesEntity(
    val confidenceRange95PercentEntity: ConfidenceRange95PercentEntity? = null,
    val unit: String? = null,
    val value: Double? = null
)
