package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionResource(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("steps")
    val steps: List<StepResource> = emptyList()
)