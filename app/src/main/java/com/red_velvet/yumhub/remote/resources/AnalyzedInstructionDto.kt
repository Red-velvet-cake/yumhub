package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("steps")
    val steps: List<com.red_velvet.yumhub.remote.resources.StepDto> = emptyList()
)