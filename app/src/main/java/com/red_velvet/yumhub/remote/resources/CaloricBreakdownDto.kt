package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class CaloricBreakdownDto(
    @SerializedName("percentCarbs")
    val percentCarbs: Double? = null,
    @SerializedName("percentFat")
    val percentFat: Double? = null,
    @SerializedName("percentProtein")
    val percentProtein: Double? = null
)