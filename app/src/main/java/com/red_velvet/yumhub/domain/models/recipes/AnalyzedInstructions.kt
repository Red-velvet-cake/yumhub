package com.red_velvet.yumhub.domain.models.recipes


data class AnalyzedInstructions(
    val name: String,
    val steps: List<Step>
)
