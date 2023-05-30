package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("steps")
    val steps: List<StepDto?>? = null
)