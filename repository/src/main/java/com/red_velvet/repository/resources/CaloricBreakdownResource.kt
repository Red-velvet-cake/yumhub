package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class CaloricBreakdownResource(
    @SerializedName("percentCarbs")
    val percentCarbs: Double? = null,
    @SerializedName("percentFat")
    val percentFat: Double? = null,
    @SerializedName("percentProtein")
    val percentProtein: Double? = null
)