package com.red_velvet.yumhub.remote.dtos


import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("steps")
    val steps: List<com.red_velvet.yumhub.remote.dtos.StepDto> = emptyList()
)