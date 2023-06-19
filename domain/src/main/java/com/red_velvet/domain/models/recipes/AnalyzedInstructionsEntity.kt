package com.red_velvet.domain.models.recipes


data class AnalyzedInstructionsEntity(
    val name: String? = "",
    val steps: List<StepEntity> = emptyList()
)
