package com.red_velvet.yumhub.domain.models.recipes


data class AnalyzedInstructionsEntity(
    val name: String,
    val stepEntities: List<StepEntity>
)