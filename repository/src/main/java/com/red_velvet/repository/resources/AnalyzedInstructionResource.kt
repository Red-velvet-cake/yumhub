package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionResource(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("steps")
    val steps: List<com.red_velvet.repository.resources.StepResource> = emptyList()
)